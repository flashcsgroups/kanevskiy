package engine;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

public interface ResultsGrabber {

    List<SelenideElement> getResultsList();

    void getItemFromList(int position);

    List<Item> serializeItems(List<SelenideElement> searchResults);

}
