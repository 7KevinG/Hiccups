public class WhiskeyFragment extends Fragment {

    private TextView mWhiskeySkin;

    @Override
    public void onViewCreated(View view, @Nullable Bundle SavedInstanceState) {
        super.onViewCreated(view, SavedInstanceState);
        getActivity().setTitle("WHISKEY EFFECTS");

        mWhiskeySkin = (TextView) view.findViewById(R.id.frag_whiskey_skin);
        mWhiskeySkin.setText(R.string.whiskey_skin);
        hasOptionsMenu();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_whiskey, container, false);
        hasOptionsMenu();
        return v;
    }
}
