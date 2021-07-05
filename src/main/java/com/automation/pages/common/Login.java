package com.automation.pages.common;

import org.openqa.selenium.WebElement;

public class Login extends Component{

    private WebElement userInput;

    private WebElement passwordInput;

    private WebElement singInButton;

    public Login(Page page, WebElement userInput, WebElement passwordInput, WebElement singInButton) {
        super(page);
        this.userInput = userInput;
        this.passwordInput = passwordInput;
        this.singInButton = singInButton;
    }

    public final void enterUser(String username) {
        this.userInput.sendKeys(username);
    }

    public final void enterPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public final void signIn(){
        this.singInButton.click();
    }

}
