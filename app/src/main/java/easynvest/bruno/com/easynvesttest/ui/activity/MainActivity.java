package easynvest.bruno.com.easynvesttest.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import easynvest.bruno.com.easynvesttest.R;
import easynvest.bruno.com.easynvesttest.modelo.Cell;
import easynvest.bruno.com.easynvesttest.modelo.ListCell;
import easynvest.bruno.com.easynvesttest.modelo.screen.ScreenMapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //Teste de leitura dos arquivos json
        ObjectMapper mapper = new ObjectMapper();

        try {
            ListCell cells = mapper.readValue(getAssets().open("cells.json"), ListCell.class);

            for(Cell cell : cells.getListCells()){
                Log.d("Cell", cell.getMessage());
            }

            ScreenMapper screen = mapper.readValue(getAssets().open("fund.json"), ScreenMapper.class);

            Log.d("Screen title", screen.getScreen().getTitle());

            for(double cdiPoint : screen.getScreen().getGraph().getCdiPoints()){
                Log.d("Graph cdi point", cdiPoint+"");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
