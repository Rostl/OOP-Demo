package by.rost.jd01_15;

public class Robot {
    public enum robotParts {
        HEAD,
        BODY,
        LEFT_HAND,
        RIGHT_HAND,
        LEFT_LEG,
        RIGHT_LEG,
        CPU,
        RAM,
        HDD;
    }

    private static robotParts[] indexOFRobotParts = robotParts.values();

    public static robotParts getPartName(int randomValue) {
        return indexOFRobotParts[randomValue];
    }
}
