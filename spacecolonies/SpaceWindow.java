package spacecolonies;

import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import list.AList;

/**
 * Creates window with all elements
 * 
 * @author nihalmitta
 * @version 04.20.2020
 */
public class SpaceWindow {

    private Window window;
    private ColonyCalculator colonyCalculator;
    private Button accept;
    private Button reject;
    private AList<CircleShape> personCircles;
    private Planet planetOne;
    private Planet planetTwo;
    private Planet planetThree;
    private Person currentPerson;
    private static final Color PLANET_ONE_COLOR = Color.BLUE;
    private static final Color PLANET_TWO_COLOR = Color.RED;
    private static final Color PLANET_THREE_COLOR = Color.GREEN;
    private static final Color PLANET_FILL_COLOR = Color.BLACK;
    private static final Color UNKOWN_COLOR = Color.ORANGE;
    private static final int PLANET_ONE_X = 125;
    private static final int PLANET_TWO_X = 350;
    private static final int PLANET_THREE_X = 575;
    private static final int PLANET_Y = 200;
    private static final int TOP_TEXT_Y = 315;
    private static final int BOT_TEXT_Y = 330;


    /**
     * Constructor
     * 
     * @param calc
     *            The data bases on files
     */
    public SpaceWindow(ColonyCalculator calc) {
        colonyCalculator = calc;
        personCircles = new AList<>();
        currentPerson = colonyCalculator.getQueue().getFront();

        window = new Window();
        window.setTitle("Space Colony Placement");
        window.setSize(800, 500);
        accept = new Button("accept");
        accept.onClick(this, "clickedAccept");
        window.addButton(accept, WindowSide.SOUTH);
        reject = new Button("reject");
        reject.onClick(this, "clickedReject");
        window.addButton(reject, WindowSide.SOUTH);

        drawPlanets();
        drawPeople();
    }


    /**
     * When accept button is clicked
     * 
     * @param button
     *            Buttom being clicked
     */
    public void clickedAccept(Button button) {

        if (colonyCalculator.accept()) {
            if (displayEndMessage()) {
                return;
            }
            window.removeAllShapes();
            drawPeople();
            drawPlanets();
        }
        else {
            accept.disable();
        }
        afterClick();
    }


    /**
     * When reject button is clicked
     * 
     * @param button
     *            Button being clicked
     */
    public void clickedReject(Button button) {
        colonyCalculator.reject();
        if (displayEndMessage()) {
            return;
        }
        window.removeAllShapes();
        drawPeople();
        drawPlanets();
        afterClick();

    }


    /**
     * Checks if accept button should be disabled
     */
    private void afterClick() {
        if (colonyCalculator.getPlanetForPerson(currentPerson) == null) {
            accept.disable();
        }
        else {
            accept.enable();
        }

    }


    /**
     * Draws Planets
     */
    public void drawPlanets() {

        Shape planet1 = new Shape(PLANET_ONE_X, PLANET_Y, 100,
            PLANET_ONE_COLOR);
        window.addShape(planet1);

        Shape planet2 = new Shape(PLANET_TWO_X, PLANET_Y, 100,
            PLANET_TWO_COLOR);
        window.addShape(planet2);

        Shape planet3 = new Shape(PLANET_THREE_X, PLANET_Y, 100,
            PLANET_THREE_COLOR);
        window.addShape(planet3);

        drawPlanetInfo();
        fillPlanet();
    }


    /**
     * Fills planets
     */
    public void fillPlanet() {
        Shape planet1 = new Shape(PLANET_ONE_X, PLANET_Y, 100, (planetOne
            .getPopulationSize() / planetOne.getCapacity()) * 100,
            PLANET_FILL_COLOR);
        window.addShape(planet1);

        Shape planet2 = new Shape(PLANET_TWO_X, PLANET_Y, 100, (planetTwo
            .getPopulationSize() / planetTwo.getCapacity()) * 100,
            PLANET_FILL_COLOR);
        window.addShape(planet2);

        Shape planet3 = new Shape(PLANET_THREE_X, PLANET_Y, 100, (planetThree
            .getPopulationSize() / planetThree.getCapacity()) * 100,
            PLANET_FILL_COLOR);
        window.addShape(planet3);
    }


    /**
     * Draws planet information
     */
    public void drawPlanetInfo() {
        planetOne = colonyCalculator.planetByNumber(1);
        planetTwo = colonyCalculator.planetByNumber(2);
        planetThree = colonyCalculator.planetByNumber(3);

        String planetOneInfoTop = planetOne.getName() + ", " + planetOne
            .getPopulationSize() + "/" + planetOne.getCapacity();
        TextShape planetOneTopText = new TextShape(PLANET_ONE_X, TOP_TEXT_Y,
            planetOneInfoTop, Color.black);
        window.addShape(planetOneTopText);

        String planetOneInfoBot = planetOne.getSKills().toString();
        TextShape planetOneBottomText = new TextShape(PLANET_ONE_X, BOT_TEXT_Y,
            planetOneInfoBot, Color.black);
        window.addShape(planetOneBottomText);

        String planetTwoInfoTop = planetTwo.getName() + ", " + planetTwo
            .getPopulationSize() + "/" + planetTwo.getCapacity();
        TextShape planetTwoTopText = new TextShape(PLANET_TWO_X, TOP_TEXT_Y,
            planetTwoInfoTop, Color.black);
        window.addShape(planetTwoTopText);

        String planetTwoInfoBot = planetTwo.getSKills().toString();
        TextShape planetTwoBottomText = new TextShape(PLANET_TWO_X, BOT_TEXT_Y,
            planetTwoInfoBot, Color.black);
        window.addShape(planetTwoBottomText);

        String planetThreeInfoTop = planetThree.getName() + ", " + planetThree
            .getPopulationSize() + "/" + planetThree.getCapacity();
        TextShape planetThreeTopText = new TextShape(PLANET_THREE_X, TOP_TEXT_Y,
            planetThreeInfoTop, Color.black);
        window.addShape(planetThreeTopText);

        String planetThreeInfoBot = planetOne.getSKills().toString();
        TextShape planetThreeBottomText = new TextShape(PLANET_THREE_X,
            BOT_TEXT_Y, planetThreeInfoBot, Color.black);
        window.addShape(planetThreeBottomText);
    }


    /**
     * Draws circles of people
     */
    public void drawPeople() {
        Object[] people = colonyCalculator.getQueue().toArray();

        for (int i = 0; i < people.length; i++) {
            Person current = (Person)people[i];
            int planetIndex = colonyCalculator.getPlanetIndex(current
                .getPlanetName());
            Color color = null;

            if (planetIndex == 1) {
                color = PLANET_ONE_COLOR;
            }
            else if (planetIndex == 2) {
                color = PLANET_TWO_COLOR;
            }
            else if (planetIndex == 3) {
                color = PLANET_THREE_COLOR;
            }
            else {
                color = UNKOWN_COLOR;
            }

            CircleShape circle = new CircleShape(75 + (i * 60), 75, 50, color);
            personCircles.add(circle);
            window.addShape(circle);

            drawPeopleInfo();
        }
    }


    /**
     * Draw information of people
     */
    public void drawPeopleInfo() {
        currentPerson = colonyCalculator.getQueue().getFront();
        TextShape info = new TextShape(10, 10, currentPerson.toString());
        window.addShape(info);
    }


    /**
     * Whether display message should show or not
     * 
     * @return True if so false if not
     */
    public boolean displayEndMessage() {
        if (colonyCalculator.getQueue().isEmpty()) {
            window.removeAllShapes();
            TextShape text = new TextShape(0, 0,
                "All Applicants Processed - Good Work!");
            text.moveTo(window.getGraphPanelWidth() / 2 - text.getWidth() / 2,
                window.getGraphPanelHeight() / 2 - text.getHeight() / 2);
            text.setBackgroundColor(Color.WHITE);
            window.addShape(text);
            accept.disable();
            reject.disable();
            return true;
        }
        return false;
    }
}
