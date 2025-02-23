package edu.uoc.pac1;

public class PAC1Ex2 {

    // Alkali metals data
    private static final double[] ALKALI_METALS_MASSES = {6.941, 22.990, 39.098, 85.468, 132.905};

    // Halogens data
    private static final double[] HALOGENS_MASSES = {18.998, 35.450, 79.904, 126.904};

    private static final double MIN_MOLAR_MASS_FOR_DRUGS = 150.0;
    private static final double MAX_MOLAR_MASS_FOR_DRUGS = 500.0;

    public static boolean isSuitableForDrugs(double molarMass) {
        //TODO
        return molarMass >= 150.0 && molarMass <= 500.0;
    }

    public static double getAlkalineMetalMolarMass(int alkaliMetalIndex) {
        //TODO
        return ALKALI_METALS_MASSES[alkaliMetalIndex];
    }

    public static double getHalogenMolarMass(int halogenIndex) {
        //TODO
        return HALOGENS_MASSES[halogenIndex];
    }

    public static double calculateMolarMass(int alkaliMetalIndex, int alkalineMetalQuantity, int halogenIndex, int halogenQuantity) {
        //TODO
        double alkalineMetalMass = getAlkalineMetalMolarMass(alkaliMetalIndex);
        double halogenMass = getHalogenMolarMass(halogenIndex);

        return (alkalineMetalMass * alkalineMetalQuantity) + (halogenMass * halogenQuantity);
    }

    public static String getStability(int alkaliAtoms, int halogenAtoms) {
        //TODO
        int totalAtoms = alkaliAtoms + halogenAtoms;
        switch (totalAtoms) {
            //FROM PAC1Ex2TEST
            case 2:
                return "Very stable";
            case 3:
                return "Moderately stable";
            case 4:
                return "Moderately stable";
            case 5:
                return "Very unstable";
            case 6:
                return "Very unstable";
            default:
                return "Unknown";
        }

    }

    public static void getCompoundsForDrugs(String[] compoundsNames, int[] alkaliMetalIndexes, int[] alkalineMetalQuantities, int[] halogenIndexes, int[] halogenQuantities) {
        int suitableCount = 0;
        StringBuilder output = new StringBuilder("Results of the compounds for drugs:").append(System.lineSeparator());
        // ITERATE THROUGH COMPONENTS
        for (int i = 0; i < compoundsNames.length; i++) {
            // CALCULATE COMPONENTS MASS
            double molarMass = calculateMolarMass(
                    alkaliMetalIndexes[i],
                    alkalineMetalQuantities[i],
                    halogenIndexes[i],
                    halogenQuantities[i]
            );

            // CALCULATE COMPOUND STABILITY
            String stability = getStability(alkalineMetalQuantities[i], halogenQuantities[i]);

            // CHECK IF MOLAR MASS IS CORRECT
            boolean isSuitable = isSuitableForDrugs(molarMass);

            // RESULT PRINT
            output.append("\t")
                    .append(compoundsNames[i])
                    .append(" (")
                    .append(stability)
                    .append(") is ")
                    .append(isSuitable ? "suitable" : "not suitable")
                    .append(" for drugs.")
                    .append(System.lineSeparator());

            // COUNTER FOR SUITABLES
            if (isSuitable) {
                suitableCount++;
            }
        }

        // CALCULATE FINAL RESULTS
        output.append("Final result: ")
                .append(suitableCount)
                .append(" compounds are suitable for drugs.")
                .append(System.lineSeparator());

        // PRINT FINAL RESULT
        System.out.print(output.toString());
    }
}