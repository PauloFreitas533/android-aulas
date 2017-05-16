package br.com.wolneyhqf.aulas.appcbr.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import br.com.wolneyhqf.aulas.appcbr.R;
import br.com.wolneyhqf.aulas.appcbr.activity.FaleConoscoActivity;
import br.com.wolneyhqf.aulas.appcbr.activity.LogActivity;
import br.com.wolneyhqf.aulas.appcbr.activity.PreferencesActivity;
import br.com.wolneyhqf.aulas.appcbr.activity.ProfileActivity;
import br.com.wolneyhqf.aulas.appcbr.util.HttpHelper;
import br.com.wolneyhqf.aulas.appcbr.util.PermissionUtil;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wolney on 10/04/17.
 */

public class ConfigFragment extends Fragment implements ListView.OnItemClickListener {

    private CircleImageView circleImageViewProfile;
    private String[] opcoes = new String[]{"Preferências", "Permissões do Aplicativo", "Logs do Aplicativo", "Fale Conosco", "Verificar Conexão", "Sair"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_config, container, false);

        circleImageViewProfile = (CircleImageView) view.findViewById(R.id.imageview_profile);
        Picasso.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/app-campeonato-brasileiro.appspot.com/o/usuarios%2Fwolney%2Fprofile.jpg?alt=media&token=ab5deac3-fe05-406b-96e5-39d7e2bf12cc")
                .placeholder(R.drawable.profile)
                .error(R.drawable.profile)
                .into(circleImageViewProfile);

        ListView listViewOpcoes = (ListView) view.findViewById(R.id.listview_opcoes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, opcoes);
        listViewOpcoes.setAdapter(adapter);
        listViewOpcoes.setOnItemClickListener(this);

        RelativeLayout profileLayout = (RelativeLayout) view.findViewById(R.id.layout_profile);
        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch(position){
            case 0:
                intent = new Intent(getContext(), PreferencesActivity.class);
                startActivity(intent);
                break;
            case 1:
                String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION};
                boolean ok = PermissionUtil.validate(getActivity(), 0, permissions);
                if(ok){
                    Toast.makeText(getContext(), "Todas as permissões foram concedidas", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                intent = new Intent(getContext(), LogActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(getContext(), FaleConoscoActivity.class);
                startActivity(intent);
                break;
            case 4:
                if(HttpHelper.hasConnection(getContext())){
                    if(HttpHelper.isWiFi(getContext())){
                        Toast.makeText(getContext(), "Conectado a rede Wi-Fi", Toast.LENGTH_SHORT).show();
                    }else if(HttpHelper.isMobileData(getContext())){
                        Toast.makeText(getContext(), "Conectado a rede de dados", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getContext(), "Sem conexão", Toast.LENGTH_SHORT).show();
                }
                break;
            case 5:
                getActivity().finish();
                break;
        }
    }
}
