public class WarthogAuto210 implements Weapon{

    @Override
    public String name() {
        return "Warthog Auto 210";
    }

    @Override
    public int getDamage() {
        return 7*8;
    }

    @Override
    public int getMagSize() {
        return 6;
    }

    @Override
    public int getAmmoCapacity() {
        return 90;
    }

    @Override
    public int getFireRate() {
        return 2;
    }

    @Override
    public double getReloadTime() {
        return 2;
    }

    @Override
    public int totalDamage() {
        return getDamage()*(getMagSize()+getAmmoCapacity());
    }

    @Override
    public double timeToKill(int health) {
        double seconds = 0;
        int remainingMag = getMagSize();
        do{
            health -= getDamage();
            if (health > 0){ //not dead
                seconds += (double) 1 / getFireRate();
                if (remainingMag == 0){
                    seconds += getReloadTime();
                    remainingMag = getMagSize();
                }else{
                    remainingMag--;
                }
            }
        }while(health>0);
        return seconds;
    }

    @Override
    public double timeToEmpty() {
        double seconds = 0;
        int mag = getMagSize();
        int reserve = getAmmoCapacity();
        do{
            if (mag > 0) { //if mag has ammo
                seconds += 1.0 / getFireRate();
                mag--;
            } else if (reserve > 0) { //if mag is empty but reserve has ammo
                seconds += getReloadTime();
                int reloadAmount = Math.min(getMagSize(), reserve);
                mag = reloadAmount;
                reserve -= reloadAmount;
            }
        }while (mag > 0 || reserve > 0);
        return seconds;
    }
}
