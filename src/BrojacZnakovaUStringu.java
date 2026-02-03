
// tu počinje

void main() {
    // ulazna datoteka
    File datoteka = new File("ulaz.txt");

    int slova = 0;
    int brojevi = 0;
    int ostalo = 0;

    // try-with-resources da bi sescanner zatvorio
    try (Scanner scanner = new Scanner(datoteka)) {
        // čita datoteku
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();

            for (int i = 0; i < s.length(); i++) {
                char znak = s.charAt(i);
                if (Character.isLetter(znak)) {
                    slova++;
                } else if (Character.isDigit(znak)) {
                    brojevi++;
                } else {
                    ostalo++;
                }
            }
        }

        // Ispis rezultata
        System.out.printf("Slova: %d%n", slova);
        System.out.printf("Brojevi: %d%n", brojevi);
        System.out.printf("Ostali znakovi: %d%n", ostalo);

    } catch (FileNotFoundException e) {
        IO.println("Pogreška: Datoteka nije pronađena!");
        e.printStackTrace();
    }
}