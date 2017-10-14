public class whiskeyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiskey);
    }

    public class Whiskeyed {

        private String whiskeySkin;
        private String whiskeyBrain;

        public String getWhiskeySkin(){
            return whiskeySkin;
        }
        public String getWhikeyBrain(){
            return whiskeyBrain;
        }
        public void setWhiskeySkin(String whiskey_skin){
            this.whiskeySkin = whiskey_skin;
        }

        public void setWhiskeyBrain(String whiskeyBrain) {
            this.whiskeyBrain = whiskeyBrain;
        }
    }

}
