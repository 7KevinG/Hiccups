public class Final extends Time {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Button backHome = (Button) findViewById(R.id.goHome);
        TextView bloodAlcoholContent = (TextView) findViewById(R.id.bloodAlcoholContent);


        Bundle f = getIntent().getExtras();
        Bundle m = getIntent().getExtras();
        final Double sendThisF = f.getDouble("actualBacF");
        final Double sendThisM = m.getDouble("actualBacM");

        if (m.containsKey("actualBacM")) {
            String displayBac = String.format("%.2f", sendThisM);

            if (sendThisM < 0.07) {
                bloodAlcoholContent.setTextColor(getResources().getColor(R.color.below_limit));
                bloodAlcoholContent.setText(displayBac);
            } else {
                bloodAlcoholContent.setTextColor(getResources().getColor(R.color.above_limit));
                bloodAlcoholContent.setText(displayBac);
            }
        }

        if (f.containsKey("actualBacF")) {
            String displayBac = String.format("%.2f", sendThisF);

            if (sendThisF < 0.07) {
                bloodAlcoholContent.setTextColor(getResources().getColor(R.color.below_limit));
                bloodAlcoholContent.setText(displayBac);
            } else {
                bloodAlcoholContent.setTextColor(getResources().getColor(R.color.above_limit));
                bloodAlcoholContent.setText(displayBac);
            }
        }
    }

    //Intent for going back to home page
    public void backHome(View V) {
        Intent homeIntent = new Intent(Final.this, MainActivity.class);
        startActivity(homeIntent);
    }
}