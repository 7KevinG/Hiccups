public class Time extends DrinkChoice{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        Button approxTime = (Button) findViewById(R.id.ApproxTime);
        final EditText timeDrinking = (EditText) findViewById(R.id.timeDrinking);

        /** Information will all Proper Calculations PRIOR TO TIME drinking including
         * (Gender Constant, Weight, Drink of Choice, Amount of Drinks, BAC as percentage)
         */
        final Bundle infoThreeM = getIntent().getExtras();
        final Bundle infoThreeF = getIntent().getExtras();
        final Double lastFormM = infoThreeM.getDouble("gramsMale");
        final Double lastFormF = infoThreeF.getDouble("gramsFemale");

        approxTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (infoThreeM.containsKey("gramsMale")) {
                    Double timeSpent = Double.parseDouble(timeDrinking.getText().toString());
                    Double yourBac = (timeSpent * 0.015);

                    Double actualBacM = (lastFormM - yourBac);

                    Bundle maleReady = new Bundle();
                    maleReady.putDouble("actualBacM", actualBacM);
                    Intent bacDone = new Intent(getApplicationContext(), Final.class);
                    bacDone.putExtras(maleReady).toString();
                    startActivity(bacDone);
                }
                else if (infoThreeF.containsKey("gramsFemale")) {
                    Double timeSpent = Double.parseDouble(timeDrinking.getText().toString());
                    Double yourBac = (timeSpent * 0.015);

                    Double actualBacF = (lastFormF - yourBac);

                    Bundle femaleReady = new Bundle();
                    femaleReady.putDouble("actualBacF", actualBacF);
                    Intent bacDone = new Intent(getApplicationContext(), Final.class);
                    bacDone.putExtras(femaleReady).toString();
                    startActivity(bacDone);
                }
            }
        });
    }
}
