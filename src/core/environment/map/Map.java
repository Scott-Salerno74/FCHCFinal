package core.environment.map;

import aima.core.util.math.geom.shapes.Point2D;

import java.util.List;

/**
 * Provides a general interface for maps.
 * 
 * @author Ruediger Lunde
 */
public interface Map {

	/** Returns a list of all locations. */
	public List<String> getLocations();

	/**
	 * Answers to the question: Where can I get, following one of the
	 * connections starting at the specified location?
	 */
	public List<String> getPossibleNextLocations(String location);

	/**
	 * Answers to the question: From where can I reach a specified location,
	 * following one of the map connections?
	 */
	public List<String> getPossiblePrevLocations(String location);

	/**
	 * Returns the travel distance between the two specified locations if they
	 * are linked by a connection and null otherwise.
	 */
	public Double getDistance(String fromLocation, String toLocation);

	/**
	 * Returns the position of the specified location. The position is
	 * represented by two coordinates, e.g. latitude and longitude values.
	 */
	public Point2D getPosition(String loc);

	/**
	 * Returns a location which is selected by random.
	 */
	public String randomlyGenerateDestination();
}
