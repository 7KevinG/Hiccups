public class AmountConsumed extends BacTest {

    public double alcGram = 14; // Weight of drinks in Grams

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_consumed);


        final EditText amount = (EditText) findViewById(R.id.amount);
        final EditText weight = (EditText) findViewById(R.id.theWeight);
        Button goForward = (Button) findViewById(R.id.goForward);


        Bundle m = getIntent().getExtras();
        Bundle f = getIntent().getExtras();
        final Double formM = m.getDouble("formOneM");
        final Double formF = f.getDouble("formOneF");

        if (m.containsKey("formOneM")) {

            goForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /** Calculate Weight in Grams * Gender Constant */
                    Double enterWeightM = Double.parseDouble(weight.getText().toString());
                    Double calculateMaleWeightGrams = (enterWeightM * 454.592);
                    Double maleWeightInGrams = (calculateMaleWeightGrams * formM);

                    /** Calculate Number of Drinks * Avg Grams per Drink */
                    Double ac = Double.parseDouble(amount.getText().toString());
                    Double gramsInDrinks = (ac * alcGram);

                    /** Alcohol Consumed in Grams */
                    Double aConsumedGrams = (gramsInDrinks / maleWeightInGrams);
                    /** Raw number multiplies by 100 */
                    Double approxBacMale = (aConsumedGrams * 100);

                    Bundle formTwoMale = new Bundle();
                    formTwoMale.putDouble("bacMale", approxBacMale);
                    Intent nowDrinkChoiceM = new Intent(getApplicationContext(), DrinkChoice.class);
                    nowDrinkChoiceM.putExtras(formTwoMale).toString();
                    startActivity(nowDrinkChoiceM);
                }
            });
        }

        else if (f.containsKey("formOneF")) {

            goForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /** Calculate Weights in Grams * Gender Constant */
                    Double enterWeightF = Double.parseDouble(weight.getText().toString());
                    Double calculateFemaleWeightGrams = (enterWeightF * 454.592);
                    Double femaleWeightInGrams = (calculateFemaleWeightGrams * formF);

                    /** Calculate Number Of Drinks * Avg Grams per Drink */
                    Double ac = Double.parseDouble(amount.getText().toString());
                    Double gramsInDrinks = (ac * alcGram);

                    /** Alcohol Consumed in Grams */
                    Double aConsumedGrams = (gramsInDrinks / femaleWeightInGrams);
                    /** Raw Number Multiplies by 100 */
                    Double approxBacFemale = (aConsumedGrams * 100);

                    Bundle formTwoFemale = new Bundle();
                    formTwoFemale.putDouble("bacFemale", approxBacFemale);
                    Intent nowDrinkChoiceF = new Intent(getApplicationContext(), DrinkChoice.class);
                    nowDrinkChoiceF.putExtras(formTwoFemale).toString();
                    startActivity(nowDrinkChoiceF);
                }
            });
        }
    }
}
