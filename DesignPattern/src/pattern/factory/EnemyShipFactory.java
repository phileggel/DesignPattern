package pattern.factory;

/**
 * Created by Phil on 02/07/2014.
 */
public class EnemyShipFactory {

    public EnemyShip makeEnemyShip(String newShipType) {

        if (newShipType.equals("U")) {

            return new UFOEnemyShip();

        } else if (newShipType.equals("U")) {

            return new RocketEnemyShip();

        } else if (newShipType.equals("B")) {

            return new BigUFOEnemyShip();

        } else {

            return null;

        }
    }
}
