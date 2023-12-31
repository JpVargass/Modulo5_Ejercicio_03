package cl.jpvs.modulo5_ejercicio_03;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.jpvs.modulo5_ejercicio_03.databinding.FragmentRespuestaBinding;


public class FragmentRespuesta extends Fragment {
    private FragmentRespuestaBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentRespuesta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRespuesta.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRespuesta newInstance(String param1, String param2) {
        FragmentRespuesta fragment = new FragmentRespuesta();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private boolean resultadoCorrecto = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("nombre");
            mParam2 = getArguments().getString(ARG_PARAM2);
            resultadoCorrecto = getArguments().getBoolean("respuesta");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRespuestaBinding.inflate(getLayoutInflater() ,container, false);

        if(resultadoCorrecto == true) {
            binding.tvRespuesta.setTextColor(Color.BLUE);
            binding.tvRespuesta.setText("Respuesta Correcta");
        } else {
            binding.tvRespuesta.setTextColor(Color.RED);
            binding.tvRespuesta.setText("Respuesta Incorrecta");
        }
        binding.btIntentalo.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("nombre",mParam1);
            Navigation.findNavController(getView()).navigate(R.id.action_fragmentRespuesta_to_triviaFragment, bundle);

        });



        return binding.getRoot();
    }
}