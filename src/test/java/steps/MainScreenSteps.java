package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.*;
import driver.AppiumTestInit;

import static common.Constants.DOUBLE_TAP_SUCCESSFUL;

public class MainScreenSteps extends AppiumTestInit {
    //TODO  refactor that
    DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
    LongPressPage longPressPage = new LongPressPage(driver);
    CarouselPage carouselPage = new CarouselPage(driver);
    WheelPickerPage wheelPickerPage = new WheelPickerPage(driver);

    @Then("^Verify that the title is displayed on main screen$")
    public void verifyThatTitleIsDisplayedOnMainScreen() {
        MainPage mainPage = new MainPage(driver);
        Assertions.assertThat(mainPage.isMenuTitleDisplayed()).isTrue();;
    }

    @And("^Select \"([^\"]*)\" menu item on main screen$")
    public void selectMenuItemOnMainScreen(String menuItem) {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenuItemByText(menuItem);
    }

    @And("^Perform double tap on the button$")
    public void performDoubleTapByButton() {
        DoubleTapPage doubleTapPage = new DoubleTapPage(driver);
        doubleTapPage.performDoubleTapByButton();
    }

    @And("^Perform drag element to the drop zone$")
    public void performDragAndDrop() {
        dragAndDropPage.dragElementAndDropInZone();
    }

    @And("Scroll Menu List down")
    public void scrollDownMenuList() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollPageDown();
    }

    @Then("^Verify that the (Circle dropped|you pressed me hard :P) text is displayed$")
    public void verifyThatSuccessTextsIsDisplayed(String message) {
        String actual;
        if ("Circle dropped".equals(message)) {
            actual = dragAndDropPage.getResultMessage();
            Assertions.assertThat(actual).isEqualTo(message);
        } else if ("you pressed me hard :P".equals(message)) {
            actual = longPressPage.getPopUpMessage();
            Assertions.assertThat(actual).isEqualTo(message);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Then("^Verify that the pop up message about success is displayed$")
    public void verifyThatDoubleTapSuccessfulIsDisplayedOnMainScreen() {
        DoubleTapPage doubleTapPage = new DoubleTapPage(driver);
        String popupText = doubleTapPage.getPopUpMessage();
        Assertions.assertThat(popupText).isEqualTo(DOUBLE_TAP_SUCCESSFUL);
    }

    @And("^Perform long press on the button$")
    public void performLongPress() {
        longPressPage.performLongPressOnButton();
    }

    @And("^Perform swipe on the (left|right)$")
    public void performHorizontalSwipe(String direction) {
        carouselPage.swipeElement(direction);
    }

    @And("^Select ([^\\\"]*) color in dropdown on Wheel Picker screen$")
    public void selectDropDownItemByColor(String color) {
        wheelPickerPage.selectDropDownItemByColor(color);
    }

    @And("^Verify that headline contains ([^\\\"]*) color on Wheel Picker screen$")
    public void checkThatHeadlineContainsCorrectColor(String color) {
        String expectedText = String.format(" Current Color: %s ", color);
        String actualText = wheelPickerPage.getHeaderColor();
        Assertions.assertThat(actualText).isEqualTo(expectedText);
    }


    @Then("^Perform swipe on the (left|right) direction and check that correct element displayed$")
    public void performAndVerifyHorizontalSwipe(String direction) {
        Integer currentNumber = Integer.valueOf(carouselPage.getSquareNumber());
        Integer expectedNumber = getNextElement(currentNumber, direction);
        carouselPage.swipeElement(direction);

        Integer actualNumber = Integer.valueOf(carouselPage.getSquareNumber());
        Assertions.assertThat(actualNumber).isEqualTo(expectedNumber);
    }


    private Integer getNextElement(Integer currentNumber, String direction) {
        if (direction.equals("left")) {
            switch (currentNumber) {
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 1;
                default:
                    throw new IllegalArgumentException("Invalid element: " + currentNumber);
            }
        } else {
            switch (currentNumber) {
                case 1:
                    return 3;
                case 2:
                    return 1;
                case 3:
                    return 2;
                default:
                    throw new IllegalArgumentException("Invalid element: " + currentNumber);
            }
        }
    }
}
