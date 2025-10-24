public interface Weapon {
    String name();
    int getDamage();
    int getMagSize();
    int getAmmoCapacity();
    int getFireRate();
    double getReloadTime();
    //methods
    int totalDamage();
    double timeToKill(int health);
    double timeToEmpty();
    String possession();
}
