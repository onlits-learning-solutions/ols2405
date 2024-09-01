package ols2405.interviewprep;

class OverridingModule {
    void method() {
        System.out.println("This method is defined in OverloadingModule class.");
    }
    void method(boolean b) {
        System.out.println("This method is defined in OverloadingModule class and accepts a boolean value.");
    }
}

public class OverloadingVsOverriding extends OverridingModule {
    @Override
    void method() {
        System.out.println("This method is defined in OverloadingVsOverriding class.");
    }

    public void main(String[] args) {
        OverridingModule overloadingVsOverriding = new OverloadingVsOverriding();
        OverridingModule test = overloadingVsOverriding;
        overloadingVsOverriding.method();
        overloadingVsOverriding.method(true);
        System.out.println(overloadingVsOverriding.equals(test));
    }
}
