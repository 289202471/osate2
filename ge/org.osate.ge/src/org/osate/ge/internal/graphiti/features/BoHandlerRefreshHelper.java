package org.osate.ge.internal.graphiti.features;

import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.aadl2.Element;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.annotations.AgeAnnotation;
import org.osate.ge.internal.annotations.Annotation;
import org.osate.ge.internal.decorations.Decoration;
import org.osate.ge.internal.decorations.DelayedDecoration;
import org.osate.ge.internal.decorations.DirectionDecoration;
import org.osate.ge.internal.decorations.ImmediateDecoration;
import org.osate.ge.internal.di.GetAnnotations;
import org.osate.ge.internal.di.GetDecorations;
import org.osate.ge.internal.di.GetDefaultDockingPosition;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.AgeShape;
import org.osate.ge.internal.graphics.AgeConnectionTerminator;
import org.osate.ge.internal.graphics.FreeFormConnection;
import org.osate.ge.internal.graphiti.PictogramElementProxy;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;
import org.osate.ge.internal.patterns.AgePattern;
import org.osate.ge.internal.query.AncestorUtil;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionCreationService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.styles.StyleConstants;
import org.osate.ge.internal.ui.util.SelectionHelper;

public class BoHandlerRefreshHelper {
	private static final int directionDecorationWidth = 8;
	private static final int connectionDecorationWidth = 2;
	private static final int delayedDecorationWidth = 6;
	private static final int immediateDecorationWidth = 10;
	
	private final ExtensionService extService;
	private final GhostingService ghostingService;
	private final LabelService labelService;
	private final ShapeCreationService shapeCreationService;
	private final ConnectionCreationService connectionCreationService;
	private final AnchorService anchorService;
	private final PropertyService propertyService;
	private final StyleService styleService;
	private final ConnectionService connectionService;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider featureProvider;
	
	public BoHandlerRefreshHelper(final ExtensionService extService,
		final GhostingService ghostingService,
		final LabelService labelService,
		final ShapeCreationService shapeCreationService,
		final ConnectionCreationService connectionCreationService,
		final AnchorService anchorService,
		final PropertyService propertyService,
		final StyleService styleService,
		final ConnectionService connectionService,
		final QueryService queryService,
		final BusinessObjectResolutionService bor,
		final IFeatureProvider featureProvider) {
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.ghostingService = Objects.requireNonNull(ghostingService, "ghostingService must not be null");
		this.labelService = Objects.requireNonNull(labelService, "labelService must not be null");
		this.shapeCreationService = Objects.requireNonNull(shapeCreationService, "shapeCreationService must not be null");
		this.connectionCreationService = Objects.requireNonNull(connectionCreationService, "connectionCreationService must not be null");
		this.anchorService = Objects.requireNonNull(anchorService, "anchorService must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.styleService = Objects.requireNonNull(styleService, "styleService must not be null");
		this.connectionService = Objects.requireNonNull(connectionService, "connectionService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.featureProvider = Objects.requireNonNull(featureProvider, "featureProvider must not be null");
	}
	
	public PictogramElement refresh(final Object bo, final Object handler, PictogramElement pe, final int x, final int y, 
			final ContainerShape addTargetContainer, final Anchor srcAnchor, final Anchor dstAnchor) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		if(pe == null && addTargetContainer == null) {
			throw new RuntimeException("pe and addTargetContainer must not both be null");
		}
		
		// Determine the logical parent
		final PictogramElement logicalParent;
		if(pe == null) {
			logicalParent = AgeFeatureUtil.getLogicalPictogramElement(addTargetContainer, propertyService);
		} else {
			logicalParent = AncestorUtil.getParent(pe, propertyService, connectionService);
		}
		
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {			
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);	
			eclipseCtx.set(InternalNames.INTERNAL_DIAGRAM_BO, bor.getBusinessObjectForPictogramElement(getDiagram()));		
			eclipseCtx.set(InternalNames.PARENT_DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(logicalParent));
			final Object gr = ContextInjectionFactory.invoke(handler, GetGraphic.class, eclipseCtx, null);
			
			// Special handling for diagram
			if(pe instanceof Diagram && gr != null) {
				featureProvider.link(pe, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
				ghostingService.setIsGhost(pe, false);
				propertyService.setIsLogicalTreeNode(pe, false);
				ghostingService.ghostChildren((Diagram)pe);
				createContextAndUpdateChild((Diagram)pe, new PictogramElementProxy(null), bo);
				
				return pe;
			}
			
			final ContainerShape childContainer; // Container for any children
			// Source and destination anchors must be set for connections
			if(gr instanceof FreeFormConnection && (srcAnchor == null || dstAnchor == null)) {
				return null;
			}
				
			// Create PE if it doesn't exist
			if(pe == null) {
				if(gr == null) {
					pe = null;
					childContainer = addTargetContainer;
				} else {
					if(gr instanceof AgeShape) {
				        // Create the container shape
						pe = childContainer = peCreateService.createContainerShape(addTargetContainer, true);
					} else if(gr instanceof FreeFormConnection) {						
				        // Create the connection
						pe = peCreateService.createFreeFormConnection(getDiagram());
						Graphiti.getGaService().createPlainPolyline(pe);
						childContainer = null;
					} else {
						throw new RuntimeException("Unsupported object: " + gr);
					}
				}
			} else if(pe instanceof ContainerShape) {
				childContainer = (ContainerShape)pe;
			} else {
				childContainer = null;
			}
			
			// Configure PE if one exists
			if(pe != null) {
				featureProvider.link(pe, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
				ghostingService.setIsGhost(pe, false);
				propertyService.setIsLogicalTreeNode(pe, true);
				
				if(pe instanceof Shape) {
					if(!(pe instanceof Diagram)) {
						anchorService.createOrUpdateChopboxAnchor((Shape)pe, AgePattern.chopboxAnchorName);
						
						// Set the dock area as appropriate
						final DockingPosition dockingPosition = (DockingPosition)ContextInjectionFactory.invoke(handler, GetDefaultDockingPosition.class, eclipseCtx, DockingPosition.NOT_DOCKED);
						if(dockingPosition == null) {
							throw new RuntimeException("Method annotated with " + GetDefaultDockingPosition.class.getName() + " must return a value of type " + DockingPosition.class + ".");
						} if(dockingPosition == DockingPosition.NOT_DOCKED) {
							propertyService.setDockArea(pe, null);
						} else {
							final String parentDockArea = propertyService.getDockArea(((Shape)pe).getContainer());
							if(parentDockArea != null) { // If parent is docked.. the child should use the group docking area								 
								propertyService.setDockArea(pe, DockArea.GROUP.id);
							} else if(propertyService.getDockArea(pe) == null) { // Only set the dock area if it has not been set.
								propertyService.setDockArea(pe, dockingPosition.getDockArea().id);
							}
							
							// Marked docked shapes as layed out so that the layout algorithm won't change the docked side.
							propertyService.setIsLayedOut(pe, true);
						}
					}
				} else if(pe instanceof Connection) {
					final Connection connection = (Connection)pe;
					// Set Anchors
			        connection.setStart(srcAnchor);
			        connection.setEnd(dstAnchor);
			        
					// Set Connection Style
			        if(!(gr instanceof AgeConnection)) {
			        	return null;
			        }
			        			        
			        final GraphicsAlgorithm ga = connection.getGraphicsAlgorithm();
			        ga.setStyle(null);
			        ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(((AgeConnection)gr).getLineStyle()));
			        ga.setLineWidth(2);
			        ga.setForeground(Graphiti.getGaService().manageColor(getDiagram(), IColorConstant.BLACK));
				}
			}

			// Create children
			if(childContainer != null) {
				// Ghost children if the PE being added or updated is the child container
				if(childContainer == pe) {
					ghostingService.ghostChildren(childContainer);
				}
				
				// Show all children.
				// TODO: Replace this with a user controllable mechanism for determining which children should be shown.
				// Refresh Children
				// It is up to the business object handler to provide children in an appropriate order(objects represented by connections should be last)
				eclipseCtx.set(InternalNames.DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(childContainer));
				eclipseCtx.set(InternalNames.PROJECT, SelectionHelper.getProject(getDiagram().eResource()));
				final Stream<?> childBos = (Stream<?>)ContextInjectionFactory.invoke(handler, GetChildren.class, eclipseCtx, null);
				if(childBos != null) {
					final DiagramElementProxy logicalContainerProxy = new PictogramElementProxy(childContainer);
					final Iterator<?> childIt = childBos.iterator();
				    if (childIt.hasNext()) {
				    	final IEclipseContext childEclipseCtx = extService.createChildContext();
				    	childEclipseCtx.remove(InternalNames.DIAGRAM_ELEMENT_PROXY);
						try {
							while(childIt.hasNext()) {
								createUpdateChild(childEclipseCtx, childContainer, logicalContainerProxy, childIt.next());
							}
						} finally {
							childEclipseCtx.dispose();
						}					    	
				    }					    
				}
			}
			
			if(pe != null) {
				// Don't create labels and graphics for diagrams
				if(!(pe instanceof Diagram)) {
					// Get the name
					eclipseCtx.set(InternalNames.DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(pe));
					final String name = (String)ContextInjectionFactory.invoke(handler, GetName.class, eclipseCtx, null);
								
					if(pe instanceof ContainerShape) {
						if(name != null) {
							final Shape labelShape = labelService.createLabelShape((ContainerShape)pe, BoHandlerFeatureHelper.nameShapeName, bo, name, true);
							labelShape.setActive(false);
						}
			
						final Annotation[] annotations = (Annotation[])ContextInjectionFactory.invoke(handler, GetAnnotations.class, eclipseCtx, null);
						if(annotations != null) {
							for(final Annotation annotation : annotations) {
								final AgeAnnotation ageAnnotation = (AgeAnnotation)annotation;
								final Shape annotationShape = labelService.createLabelShape((ContainerShape)pe, BoHandlerFeatureHelper.annotationsShapeName, bo, ageAnnotation.text, true);
								annotationShape.setActive(false);
							}
						}
					} else if(pe instanceof Connection) {
						final Connection connection = (Connection)pe;

						int labelX = 0;
						int labelY = 0;
						if(name != null) {
							// Before removing all the decorators, get position of the label(if one exists)
							for(final ConnectionDecorator d : connection.getConnectionDecorators()) {
								if(BoHandlerFeatureHelper.nameShapeName.equals(propertyService.getName(d))) {
									if(d.getGraphicsAlgorithm() != null) {
										final Text text = (Text)d.getGraphicsAlgorithm();
										labelX = text.getX();
										labelY = text.getY();
									}
								}
							}
						}
						
						// Clear decorators
						connection.getConnectionDecorators().clear();

						// Create label decorator
						if(name != null) {
					        final IGaService gaService = Graphiti.getGaService();
							final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
							final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
							text.setStyle(styleService.getStyle(StyleConstants.LABEL_STYLE));
							propertyService.setName(textDecorator, BoHandlerFeatureHelper.nameShapeName);
							gaService.setLocation(text, labelX, labelY);					 		
						    text.setValue(name);
						    featureProvider.link(textDecorator, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
						}
						
						// Create Graphiti decorators for connection terminators
					    final AgeConnection ageConnection = (AgeConnection)gr;
					    createDecorator(connection, ageConnection.getSourceTerminator(), 0.0);
					    createDecorator(connection, ageConnection.getDestinationTerminator(), 1.0);
					    
					    // Create Graphiti decorators based on decorations
					    final Decoration[] decorations = (Decoration[])ContextInjectionFactory.invoke(handler, GetDecorations.class, eclipseCtx, null);
					    if(decorations != null) {
					    	createConnectionDecorators(connection, decorations);
					    }
					}
					
					// Refresh Graphics Algorithm. Connections do not have their graphics algorithms recreated because they all have the same type of GraphicsAlgorithm
					// and because there are issues when recreating the graphics algorithm of connections. Upon update, the connections may disappear.
					if(pe instanceof Shape) {
						final Shape shape = (Shape)pe;
						final GraphicsAlgorithm oldGa = shape.getGraphicsAlgorithm();
						final int width = Math.max(10, oldGa == null ? 0 : oldGa.getWidth());
						final int height = Math.max(10, oldGa == null ? 10 : oldGa.getHeight());
	
						// Set the position of the refreshed graphics algorithm
						final IGaService gaService = Graphiti.getGaService();
						final GraphicsAlgorithm newGa = gaService.createInvisibleRectangle(shape);
						gaService.setLocationAndSize(newGa, x, y, width, height);
					}
					
					// Layout the shape
					if(pe instanceof Shape) {
						final LayoutContext context = new LayoutContext(pe);
						featureProvider.layoutIfPossible(context);
					}
				}
			}
			
		} finally {
			eclipseCtx.dispose();
		}	
	
		return pe;
	}	
	
	private void createConnectionDecorators(final Connection connection, final Decoration[] decorations) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Determine width of all the connection decorations
		int totalDecorationsWidth = 0;
		for(final Decoration decoration : decorations) {
    		final Class<?> decorationClass = decoration.getClass();
    		if(decorationClass == DelayedDecoration.class) {
    			totalDecorationsWidth += delayedDecorationWidth + connectionDecorationWidth;
    		} else if(decorationClass == ImmediateDecoration.class) {
    			totalDecorationsWidth += immediateDecorationWidth + directionDecorationWidth + connectionDecorationWidth;
    		} else if(decorationClass == DirectionDecoration.class) {
    	        totalDecorationsWidth += directionDecorationWidth + connectionDecorationWidth;
    		}
    	}
		
		// Center decorations
		int decoratorX = -totalDecorationsWidth/2;
    	for(final Decoration decoration : decorations) {
    		final Class<?> decorationClass = decoration.getClass();
    		if(decorationClass == DelayedDecoration.class) {
    			final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
    			createDelayedIndicator(timingDecorator1, connection.getParent(), decoratorX);
    			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
    			createDelayedIndicator(timingDecorator2, connection.getParent(), decoratorX + delayedDecorationWidth);
    			decoratorX += delayedDecorationWidth + connectionDecorationWidth;
    		} else if(decorationClass == ImmediateDecoration.class) {
    			final ConnectionDecorator timingDecorator1 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
    			createDirectionIndicator(timingDecorator1, connection.getParent(), decoratorX);
    			final ConnectionDecorator timingDecorator2 = peCreateService.createConnectionDecorator(connection, false, 0.5, true);
    			createDirectionIndicator(timingDecorator2, connection.getParent(), decoratorX + immediateDecorationWidth);
    			decoratorX += immediateDecorationWidth + directionDecorationWidth + connectionDecorationWidth;
    		} else if(decorationClass == DirectionDecoration.class) {
    	        final ConnectionDecorator directionDecorator = peCreateService.createConnectionDecorator(connection, false, 0.5, true);    
    	        createDirectionIndicator(directionDecorator, connection.getParent(), decoratorX);
     	        decoratorX += directionDecorationWidth + connectionDecorationWidth;
    		}
    	}
	}

	private GraphicsAlgorithm createDelayedIndicator(final GraphicsAlgorithmContainer gaContainer, final Diagram diagram, final int x) {
	    final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainPolyline(gaContainer, new int[] {
			x, -10, 
			x, 10});
		
		ga.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
        ga.setBackground(gaService.manageColor(diagram, IColorConstant.BLACK));
        ga.setLineStyle(LineStyle.SOLID);
        ga.setLineVisible(true);
        ga.setLineWidth(2);
        
		return ga;
	}
	
	private GraphicsAlgorithm createDirectionIndicator(final GraphicsAlgorithmContainer gaContainer, final Diagram diagram, final int x) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolyline(gaContainer, new int[] {
	    		x+directionDecorationWidth, 6, 
	    		x, 0, 
	    		x+directionDecorationWidth, -6});
	    
	    ga.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
        ga.setBackground(gaService.manageColor(diagram, IColorConstant.BLACK));
        ga.setLineStyle(LineStyle.SOLID);
        ga.setLineVisible(true);
        ga.setLineWidth(2);
        
	    return ga;
	}
	
	private void createDecorator(final Connection connection, final AgeConnectionTerminator terminator, final double position) {
		if(terminator != null) {
			final IPeCreateService peCreateService = Graphiti.getPeCreateService();
			final ConnectionDecorator cd = peCreateService.createConnectionDecorator(connection, false, position, true);
			final Diagram diagram = connection.getParent();
			final Color black = Graphiti.getGaService().manageColor(diagram, IColorConstant.BLACK);
			final Color white = Graphiti.getGaService().manageColor(diagram, IColorConstant.WHITE);

			switch(terminator) {
			case FILLED_ARROW: {
				final GraphicsAlgorithm ga = createPolygonArrow(cd);
			    ga.setForeground(black);
			    ga.setBackground(black);
				break;
			}
				
			case OPEN_ARROW: {
				final GraphicsAlgorithm ga = createPolygonArrow(cd);
			    ga.setForeground(black);
			    ga.setBackground(white);
				break;
			}
				
			default:
				throw new RuntimeException("Unhandled case: " + terminator);
			}
		}
	}
	
	private GraphicsAlgorithm createPolygonArrow(final GraphicsAlgorithmContainer gaContainer) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] {
	    		-14, 8, 
	    		2, 0, 
	    		-14, -8});
	    return ga;
	}
	
	private void createContextAndUpdateChild(final ContainerShape containerShape, final DiagramElementProxy logicalContainer, final Object childBo) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {			
			createUpdateChild(eclipseCtx, containerShape, logicalContainer, childBo);
		} finally {
			eclipseCtx.dispose();
		}
	}
	
	private void createUpdateChild(final IEclipseContext eclipseCtx, final ContainerShape containerShape, final DiagramElementProxy logicalContainer, final Object childBo) {
		final Object childBoHandler = extService.getApplicableBusinessObjectHandler(childBo);
		if(childBoHandler != null) {
			eclipseCtx.set(Names.BUSINESS_OBJECT, childBo);			
			eclipseCtx.set(InternalNames.INTERNAL_DIAGRAM_BO, bor.getBusinessObjectForPictogramElement(getDiagram()));
			eclipseCtx.set(InternalNames.PARENT_DIAGRAM_ELEMENT_PROXY, logicalContainer);
			final Object gr = ContextInjectionFactory.invoke(childBoHandler, GetGraphic.class, eclipseCtx, null);
			if(gr instanceof AgeShape || gr == null) { // Handle null graphic to allow for business object handlers which are just containers but have no graphical representation.
				shapeCreationService.createUpdateShape(containerShape, childBo);
			} else if(gr instanceof AgeConnection) {
				connectionCreationService.createUpdateConnection(containerShape, childBo);
			} else {
				throw new RuntimeException("Unsupported graphical representation: " + gr + " for " + childBo);
			}
		}
	}
	
	private Diagram getDiagram() {
		return featureProvider.getDiagramTypeProvider().getDiagram();
	}
}
