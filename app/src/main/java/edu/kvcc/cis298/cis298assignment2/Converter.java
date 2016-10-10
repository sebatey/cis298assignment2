package edu.kvcc.cis298.cis298assignment2;

/**
 * Created by sbatey1397 on 10/10/2016.
 */
public class Converter {

    public String mSolution;
    public double c;

    /////////////////////////////////////////////////////
    //////////////////// Constructor ////////////////////
    ////////////////////////////////////////////////////

    public Converter() {

    }

    /////////////////////////////////////////////////////
    ////////////////////// Methods //////////////////////
    ////////////////////////////////////////////////////
    public String calculate(String s, int from, int to) {
        if (s.isEmpty()) {
            mSolution = "x";
        } else {
            switch (from) {
                case 2131492943:
                    switch (to) {
                        case 2131492948:
                            mSolution = "x";
                            break;
                        case 2131492949:
                            mSolution = String.valueOf(fromCtoF(s));
                            break;
                        case 2131492950:
                            mSolution = String.valueOf(fromCtoK(s));
                            break;
                        case 2131492951:
                            mSolution = String.valueOf(fromCtoR(s));
                            break;
                    }
                    break;
                case 2131492944:
                    switch (to) {
                        case 2131492948:
                            mSolution = String.valueOf(fromFtoC(s));
                            break;
                        case 2131492949:
                            mSolution = "x";
                            break;
                        case 2131492950:
                            mSolution = String.valueOf(fromFtoK(s));
                            break;
                        case 2131492951:
                            mSolution = String.valueOf(fromFtoR(s));
                            break;
                    }
                    break;
                case 2131492945:
                    switch (to) {
                        case 2131492948:
                            mSolution = String.valueOf(fromKtoC(s));
                            break;
                        case 2131492949:
                            mSolution = String.valueOf(fromKtoF(s));
                            break;
                        case 2131492950:
                            mSolution = "x";
                            break;
                        case 2131492951:
                            mSolution = String.valueOf(fromKtoR(s));
                            break;
                    }
                    break;
                case 2131492946:
                    switch (to) {
                        case 2131492948:
                            mSolution = String.valueOf(fromRtoC(s));
                            break;
                        case 2131492949:
                            mSolution = String.valueOf(fromRtoF(s));
                            break;
                        case 2131492950:
                            mSolution = String.valueOf(fromRtoK(s));
                            break;
                        case 2131492951:
                            mSolution = "x";
                            break;
                    }
                    break;
            }
        }
        return mSolution;
    }


    public double fromCtoF(String s){
        c = Double.parseDouble(s);
        return (c * (9.0/5.0) + 32);
    }

    public double fromCtoK(String s){
        c = Double.parseDouble(s);
        return (c + 273.15);
    }

    public double fromCtoR(String s){
        c = Double.parseDouble(s);
        return ((c + 273.15) * (9.0/5.0));
    }

    public double fromFtoC(String s){
        c = Double.parseDouble(s);
        return ((c - 32) * (5.0/9.0));
    }

    public double fromFtoK(String s){
        c = Double.parseDouble(s);
        return ((c + 459.67) * (5.0/9.0));
    }

    public double fromFtoR(String s){
        c = Double.parseDouble(s);
        return (c + 459.67);
    }

    public double fromKtoC(String s){
        c = Double.parseDouble(s);
        return (c - 273.15);
    }

    public double fromKtoF(String s){
        c = Double.parseDouble(s);
        return (c * (9.0/5.0) - 459.67);
    }

    public double fromKtoR(String s){
        c = Double.parseDouble(s);
        return (c * (9.0/5.0));
    }

    public double fromRtoC(String s){
        c = Double.parseDouble(s);
        return ((c - 491.67) * (5.0/9.0));
    }

    public double fromRtoF(String s){
        c = Double.parseDouble(s);
        return (c - 459.67);
    }

    public double fromRtoK(String s){
        c = Double.parseDouble(s);
        return (c * (5.0/9.0));
    }

}
