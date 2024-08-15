package chapters.ten.anonymous.monsters;

public class HorrorShow {
    public static void main(String[] args) {
        DangerousMonster barney = new DangerousMonster() {
            @Override
            public void menace() {
                System.out.println("DangerousMonster.menace()");
            }

            @Override
            public void destroy() {
                System.out.println("DangerousMonster.destroy()");
            }
        };

        Vampire vlad = new Vampire() {
            @Override
            public void drinkBlood() {
                System.out.println("Vampire.drinkBlood()");
            }

            @Override
            public void destroy() {
                System.out.println("Vampire.destroy()");
            }

            @Override
            public void kill() {
                System.out.println("Vampire.kill()");
            }

            @Override
            public void menace() {
                System.out.println("Vampire.menace()");
            }
        };

        u(barney);
        v(barney);

        u(vlad);
        v(vlad);
        w(vlad);
    }

    private static void u(Monster monster) {
        monster.menace();
    }

    private static void v(DangerousMonster monster) {
        monster.menace();
        monster.destroy();
    }

    private static void w(Lethal lethal) {
        lethal.kill();
    }
}
