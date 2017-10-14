public class pageone extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageone);
        setupDrawer();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }

    /**
     *
     * @param menu for top right corner
     * @return Inflated the menu drawer?
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawermenu, menu);
        return true;
    }
    /**
     *
     * @param item Clickable menu drawers
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()) {
            case itemWhiskey:
                Intent whiskeyIntent = new Intent(pageone.this, whiskeyActivity.class);
                startActivity(whiskeyIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Make sure the drawer open and closes in sync with UI visual
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    /**
     * Function to make sure all the drawer open & closes properly
     */
    public void setupDrawer() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_pageone);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_closed) {
            @Override
            public void onDrawerClosed(View closeView) {
                Toast.makeText(pageone.this, "Happy You Learned", Toast.LENGTH_SHORT).show();
                super.onDrawerClosed(closeView);
                invalidateOptionsMenu();
            }
            @Override
            public void onDrawerOpened(View openView) {
                Toast.makeText(pageone.this, "Effects Of Alcohol", Toast.LENGTH_SHORT).show();
                super.onDrawerOpened(openView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.addDrawerListener(mToggle);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_header);
        final MenuItem itemWhiskey = (MenuItem) findViewById(R.id.itemWhiskey);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.itemWhiskey:
                        Intent whiskeyIntent = new Intent(pageone.this, whiskeyActivity.class);
                        startActivity(whiskeyIntent);
                        itemWhiskey.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;
                }
                return false;
            }
        });
        mDrawerLayout.closeDrawer(GravityCompat.START, true);
        return true;
    }
}
