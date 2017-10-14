public class BacTest extends AppCompatActivity {

    //Holds the Male calculation
    public double maleCalc = 0;

    //Holds the Female calculation
    public double femaleCalc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac_test);

        /**
         * RadioButton Assignments
         */

        RadioButton maleDrunk = (RadioButton) findViewById(R.id.maleButton);
        RadioButton femaleDrunk = (RadioButton) findViewById(R.id.femaleButton);

        /**
         * Specify the Gender Calculation for Males
         */
        maleDrunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                maleCalc = maleCalc + 0.69;
                Bundle m = new Bundle();
                m.putDouble("formOneM", maleCalc);
                Intent maleIntent = new Intent(getApplicationContext(), AmountConsumed.class);
                maleIntent.putExtras(m).toString();
                startActivity(maleIntent);
            }
        });

        /**
         * Specify the Gender for Calculation for Females
         */
        femaleDrunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                femaleCalc = femaleCalc + 0.56;
                Bundle f = new Bundle();
                f.putDouble("formOneF", femaleCalc);
                Intent femaleIntent = new Intent(getApplicationContext(), AmountConsumed.class);
                femaleIntent.putExtras(f).toString();
                startActivity(femaleIntent);
            }
        });
    }
}