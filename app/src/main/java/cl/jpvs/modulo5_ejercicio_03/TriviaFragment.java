package cl.jpvs.modulo5_ejercicio_03;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.jpvs.modulo5_ejercicio_03.databinding.FragmentTriviaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TriviaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TriviaFragment extends Fragment {
    private FragmentTriviaBinding binding;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TriviaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TriviaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TriviaFragment newInstance(String param1, String param2) {
        TriviaFragment fragment = new TriviaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("nombre"); //recoge el valor desde FragmenName
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTriviaBinding.inflate(getLayoutInflater() ,container, false);
        binding.tVName.setText("Hola, "+ mParam1);
        binding.btnEnviar.setOnClickListener(view -> {


            boolean correcto = false;
            Bundle bundle = new Bundle();

            // radioButton = Gengar,  radioButton2 = Raiikou
            if(binding.radioGroupPokemon.getCheckedRadioButtonId() == binding.radioButton.getId()){
                correcto = true;
            }


            bundle.putString("nombre",mParam1);
            bundle.putBoolean("respuesta",correcto);
            Navigation.findNavController(getView()).navigate(R.id.action_triviaFragment_to_fragmentRespuesta, bundle);


        });

        return binding.getRoot();
    }
}