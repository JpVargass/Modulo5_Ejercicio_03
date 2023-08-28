package cl.jpvs.modulo5_ejercicio_03;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.jpvs.modulo5_ejercicio_03.databinding.FragmentNameBinding;

public class FragmentName extends Fragment {
    private FragmentNameBinding binding;  //habilitar binding
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public FragmentName() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
  binding = FragmentNameBinding.inflate(getLayoutInflater(), container,false);
  binding.btnComenzar.setOnClickListener(view -> {

      String nombre = binding.editTextName.getText().toString();
      Bundle bundle = new Bundle();  // cajita donde se guarda datos
      bundle.putString("nombre", nombre);  //"nombre" = key , nombre = el contenido
      Navigation.findNavController(getView()).navigate(R.id.action_fragmentName_to_triviaFragment,bundle);
  });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}