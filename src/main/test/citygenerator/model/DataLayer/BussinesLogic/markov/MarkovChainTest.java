package citygenerator.model.DataLayer.BussinesLogic.markov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.*;

public class MarkovChainTest {

    MarkovChain textGenerator;
    Stack<String> data;

    String[] wordlist = {
            "dingolfing","dinkelsbühl","dinklage","dinslaken","dippoldiswalde","dissen","ditzingen","doberlug","dohna",
            "dommitzsch","donaueschingen","donauwörth","donzdorf","dorfen","dormagen","dornburg","dornhan",
            "dornstetten","dorsten","dortmund","dransfeld","drebkau","dreieich","drensteinfurt","dresden","drolshagen",
            "duderstadt","duisburg","döbeln","döbern","dömitz","dülmen","düren","düsseldorf","ebeleben","eberbach",
            "ebermannstadt","ebern","ebersbach","ebersbach","ebersberg","eberswalde","eckartsberga","eckernförde",
            "edenkoben","egeln","eggenfelden","eggesin","ehingen","ehrenfriedersdorf","eibelstadt","eibenstock",
            "eichstätt","eilenburg","einbeck","eisenach","eisenberg","eisenberg","eisenhüttenstadt","eisfeld",
            "eisleben","eislingen","ellingen","ellrich","ellwangen","elmshorn","elsdorf","elsfleth","elsterberg",
            "elsterwerda","elstra","elterlein","eltmann","eltville","elzach","elze","emden","emmelshausen",
            "emmendingen","emmerich","emsdetten","endingen","engen","enger","ennepetal","ennigerloh","eppelheim",
            "eppingen","eppstein","erbach","erbach","erbendorf","erding","erftstadt","erfurt","erkelenz","erkner",
            "erkrath","erlangen","erlenbach","erlensee","erwitte","eschborn","eschenbach","eschershausen","eschwege",
            "eschweiler","esens","espelkamp","essen","esslingen","ettenheim","ettlingen","euskirchen","eutin",
            "falkenberg","falkensee","falkenstein","falkenstein","fehmarn","fellbach","felsberg","feuchtwangen",
            "filderstadt","finsterwalde","fladungen","flensburg","florstadt","flöha","flörsheim","forchheim",
            "forchtenberg","forst","frankenau","frankenberg","frankenberg","frankenthal","frankfurt","frankfurt",
            "franzburg","frauenstein","frechen","freiberg","freiberg","freiburg","freilassing","freinsheim","freising",
            "freital","freren","freudenberg","freudenberg","freudenstadt","freyburg","freystadt","freyung","fridingen",
            "friedberg","friedberg","friedland","friedland","friedrichroda","friedrichsdorf","friedrichshafen",
            "friedrichstadt","friedrichsthal","friesack","friesoythe","fritzlar","frohburg","fröndenberg","fulda",
            "furth","grafenau","grafenwöhr","grafing","gransee","grebenau","grebenstein","greding","greifswald",
            "greiz","greußen","greven","grevenbroich","grevesmühlen","griesheim","grimma","grimmen","groitzsch",
            "gronau","gronau","groß","groß","groß","großalmerode","großbottwar","großbreitenbach","großenehrich",
            "großenhain","großräschen","großröhrsdorf","großschirma","gräfenberg","gräfenhainichen","gräfenthal",
            "gröditz","gröningen","grünberg","grünhain","grünsfeld","grünstadt","guben","gudensberg","gummersbach",
            "gundelfingen","gundelsheim","gunzenhausen","göppingen","görlitz","göttingen","gößnitz","güglingen",
            "günzburg","heiligenhafen","heiligenhaus","heilsbronn","heimbach","heimsheim","heinsberg","heitersheim",
            "heldrungen","helmbrechts","helmstedt","hemau","hemer","hemmingen","hemmoor","hemsbach","hennef",
            "hennigsdorf","heppenheim","herbolzheim","herborn","herbrechtingen","herbstein","herdecke","herdorf",
            "herford","heringen","heringen","hermeskeil","hermsdorf","herne","herrenberg","herrieden","herrnhut",
            "hersbruck","herten","herzberg","herzberg","herzogenaurach","herzogenrath","hessisch","hessisch",
            "hettingen","hettstedt","heubach","heusenstamm","hilchenbach","hildburghausen","hilden","hildesheim"};

    @Before
    public void setUp() {
        this.data = new Stack<>();
        this.data.addAll(Arrays.asList(wordlist));
        textGenerator = new MarkovChain(data, 8, 0.0f);
    }

    @Test
    public void generateTest() {
        String s = textGenerator.generateName();
        Assert.assertEquals("ellsberg", s);
        s = textGenerator.generateName();
        Assert.assertEquals("heimbach", s);
    }
}