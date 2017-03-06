package easynvest.bruno.com.easynvesttest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import easynvest.bruno.com.easynvesttest.modelo.Cell;
import easynvest.bruno.com.easynvesttest.modelo.ListCell;

/**
 * Created by Bruno on 05/03/2017.
 */
@RunWith(AndroidJUnit4.class)
public class CellsGenerationTest {

    @Test
    public void convertJsonToObject() throws IOException{
        Context appContext = InstrumentationRegistry.getTargetContext();

        int expectedId = 1;
        int expectedType = 2;
        String expectedMessage = "Olá, primeiro se apresente com o seu nome:";
        String expectedTypeField = null;
        boolean expectedHidden = false;
        double expectedTopSpacing = 60.0;
        int expectedShow = 0;
        boolean expectedRequired = false;

        ObjectMapper mapper = new ObjectMapper();

        ListCell cells = mapper.readValue(appContext.getAssets().open("cells.json"), ListCell.class);

        Cell cellToBeTested = cells.getListCells().get(0);

        Assert.assertEquals(expectedId, cellToBeTested.getId());
        Assert.assertEquals(expectedType, cellToBeTested.getType());
        Assert.assertEquals(expectedMessage, cellToBeTested.getMessage());
        Assert.assertEquals(expectedTypeField, cellToBeTested.getTypeField());
        Assert.assertEquals(expectedHidden, cellToBeTested.isHidden());
        Assert.assertEquals(expectedTopSpacing, cellToBeTested.getTopSpacing(), 0.001);
        Assert.assertEquals(expectedShow, cellToBeTested.getShow());
        Assert.assertEquals(expectedRequired,  cellToBeTested.isRequired());
    }

}
