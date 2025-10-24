public class WeaponDriver {
    public static void main(String[] args) {
        //pulling weapons
        Weapon[] Guns = {new WarthogAuto210(), new LeadStormPoweredMinigun(), new FlareGun()};
        //listing stuff
        for (Weapon g : Guns){
            int targetHealth = 1000;
            System.out.println("--- " + g.name() + " ---");
            System.out.println("Total damage the gun can deal before empty: " + g.totalDamage() + " damage");
            System.out.println("Time to kill the target with " + targetHealth + "hp: " + g.timeToKill(targetHealth) + " seconds");
            System.out.println("Time to fully empty the gun of ammo: " + g.timeToEmpty() + " seconds");
            System.out.println();
        }
    }
}
