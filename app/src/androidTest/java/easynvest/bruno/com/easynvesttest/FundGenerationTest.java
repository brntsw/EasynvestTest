package easynvest.bruno.com.easynvesttest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import easynvest.bruno.com.easynvesttest.modelo.screen.ScreenMapper;

/**
 * Created by Bruno on 05/03/2017.
 */
@RunWith(AndroidJUnit4.class)
public class FundGenerationTest {

    @Test
    public void convertJsonToObject() throws IOException{
        Context appContext = InstrumentationRegistry.getTargetContext();

        String expectedTitle = "Fundos de investimento";
        String expectedFundName = "Vinci Valorem FI Multimercado";
        String expectedWhatIs = "O que é?";
        String expectedDefinition = "O Fundo tem por objetivo proporcionar aos seus cotistas rentabilidade no longo prazo através de investimentos.";
        String expectedRiskTitle = "Grau de risco do investimento";
        int expectedRisk = 4;
        String expectedInfoTitle = "Mais informações sobre o investimento";

        ObjectMapper mapper = new ObjectMapper();

        ScreenMapper screenMapper = mapper.readValue(appContext.getAssets().open("fund.json"), ScreenMapper.class);

        Assert.assertEquals(expectedTitle, screenMapper.getScreen().getTitle());
        Assert.assertEquals(expectedFundName, screenMapper.getScreen().getFundName());
        Assert.assertEquals(expectedWhatIs, screenMapper.getScreen().getWhatIs());
        Assert.assertEquals(expectedDefinition, screenMapper.getScreen().getDefinition());
        Assert.assertEquals(expectedRiskTitle, screenMapper.getScreen().getRiskTitle());
        Assert.assertEquals(expectedRisk, screenMapper.getScreen().getRisk());
        Assert.assertEquals(expectedInfoTitle, screenMapper.getScreen().getInfoTitle());
    }

}
