package com.mobi.btl.cocktail.utils;

import androidx.annotation.NonNull;

import com.mobi.btl.cocktail.api.result.Cocktail;
import com.mobi.btl.cocktail.model.CocktailModel;
import com.mobi.btl.cocktail.model.FormulaCocktail;

import java.util.ArrayList;
import java.util.List;

public class AppUtils {
    public static Cocktail convertCocktail(@NonNull CocktailModel data) {
        Cocktail cocktail = new Cocktail();
        cocktail.setIdDrink(data.getIdDrink());

        cocktail.setStrAlcoholic(data.getStrAlcoholic());
        cocktail.setStrCategory(data.getStrCategory());

        cocktail.setStrDrink(data.getStrDrink());
        cocktail.setStrDrinkThumb(data.getStrDrinkThumb());
        cocktail.setStrDrinkAlternate(data.getStrDrinkAlternate());

        cocktail.setStrGlass(data.getStrGlass());
        cocktail.setStrCreativeCommonsConfirmed(data.getStrCreativeCommonsConfirmed());
        cocktail.setStrIBA(data.getStrIBA());

        cocktail.setStrImageAttribution(data.getStrImageAttribution());
        cocktail.setStrImageSource(data.getStrImageSource());

        cocktail.setStrIngredient1(data.getStrIngredient1());
        cocktail.setStrIngredient2(data.getStrIngredient2());
        cocktail.setStrIngredient3(data.getStrIngredient3());
        cocktail.setStrIngredient4(data.getStrIngredient4());
        cocktail.setStrIngredient5(data.getStrIngredient5());
        cocktail.setStrIngredient6(data.getStrIngredient6());
        cocktail.setStrIngredient7(data.getStrIngredient7());
        cocktail.setStrIngredient8(data.getStrIngredient8());
        cocktail.setStrIngredient9(data.getStrIngredient9());
        cocktail.setStrIngredient10(data.getStrIngredient10());
        cocktail.setStrIngredient11(data.getStrIngredient11());
        cocktail.setStrIngredient12(data.getStrIngredient12());
        cocktail.setStrIngredient13(data.getStrIngredient13());
        cocktail.setStrIngredient14(data.getStrIngredient14());
        cocktail.setStrIngredient15(data.getStrIngredient15());

        cocktail.setStrMeasure1(data.getStrMeasure1());
        cocktail.setStrMeasure2(data.getStrMeasure2());
        cocktail.setStrMeasure3(data.getStrMeasure3());
        cocktail.setStrMeasure4(data.getStrMeasure4());
        cocktail.setStrMeasure5(data.getStrMeasure5());
        cocktail.setStrMeasure6(data.getStrMeasure6());
        cocktail.setStrMeasure7(data.getStrMeasure7());
        cocktail.setStrMeasure8(data.getStrMeasure8());
        cocktail.setStrMeasure9(data.getStrMeasure9());
        cocktail.setStrMeasure10(data.getStrMeasure10());
        cocktail.setStrMeasure11(data.getStrMeasure11());
        cocktail.setStrMeasure12(data.getStrMeasure12());
        cocktail.setStrMeasure13(data.getStrMeasure13());
        cocktail.setStrMeasure14(data.getStrMeasure14());
        cocktail.setStrMeasure15(data.getStrMeasure15());

        cocktail.setStrTags(data.getStrTags());
        cocktail.setStrVideo(data.getStrVideo());

        cocktail.setStrInstructions(data.getStrInstructions());
        cocktail.setStrInstructionsDE(data.getStrInstructionsDE());
        cocktail.setStrInstructionsES(data.getStrInstructionsES());
        cocktail.setStrInstructionsFR(data.getStrInstructionsFR());
        cocktail.setStrInstructionsIT(data.getStrInstructionsIT());
        cocktail.setStrInstructionsZH_HANS(data.getStrInstructionsZH_HANS());
        cocktail.setStrInstructionsZH_HANT(data.getStrInstructionsZH_HANT());

        cocktail.setDateModified(data.getDateModified());
        return cocktail;
    }
    public static CocktailModel convertCocktailModel(@NonNull Cocktail data) {
        CocktailModel cocktail = new CocktailModel();
        cocktail.setIdDrink(data.getIdDrink());

        cocktail.setStrAlcoholic(data.getStrAlcoholic());
        cocktail.setStrCategory(data.getStrCategory());

        cocktail.setStrDrink(data.getStrDrink());
        cocktail.setStrDrinkThumb(data.getStrDrinkThumb());
        cocktail.setStrDrinkAlternate(data.getStrDrinkAlternate());

        cocktail.setStrGlass(data.getStrGlass());
        cocktail.setStrCreativeCommonsConfirmed(data.getStrCreativeCommonsConfirmed());
        cocktail.setStrIBA(data.getStrIBA());

        cocktail.setStrImageAttribution(data.getStrImageAttribution());
        cocktail.setStrImageSource(data.getStrImageSource());

        cocktail.setStrIngredient1(data.getStrIngredient1());
        cocktail.setStrIngredient2(data.getStrIngredient2());
        cocktail.setStrIngredient3(data.getStrIngredient3());
        cocktail.setStrIngredient4(data.getStrIngredient4());
        cocktail.setStrIngredient5(data.getStrIngredient5());
        cocktail.setStrIngredient6(data.getStrIngredient6());
        cocktail.setStrIngredient7(data.getStrIngredient7());
        cocktail.setStrIngredient8(data.getStrIngredient8());
        cocktail.setStrIngredient9(data.getStrIngredient9());
        cocktail.setStrIngredient10(data.getStrIngredient10());
        cocktail.setStrIngredient11(data.getStrIngredient11());
        cocktail.setStrIngredient12(data.getStrIngredient12());
        cocktail.setStrIngredient13(data.getStrIngredient13());
        cocktail.setStrIngredient14(data.getStrIngredient14());
        cocktail.setStrIngredient15(data.getStrIngredient15());

        cocktail.setStrMeasure1(data.getStrMeasure1());
        cocktail.setStrMeasure2(data.getStrMeasure2());
        cocktail.setStrMeasure3(data.getStrMeasure3());
        cocktail.setStrMeasure4(data.getStrMeasure4());
        cocktail.setStrMeasure5(data.getStrMeasure5());
        cocktail.setStrMeasure6(data.getStrMeasure6());
        cocktail.setStrMeasure7(data.getStrMeasure7());
        cocktail.setStrMeasure8(data.getStrMeasure8());
        cocktail.setStrMeasure9(data.getStrMeasure9());
        cocktail.setStrMeasure10(data.getStrMeasure10());
        cocktail.setStrMeasure11(data.getStrMeasure11());
        cocktail.setStrMeasure12(data.getStrMeasure12());
        cocktail.setStrMeasure13(data.getStrMeasure13());
        cocktail.setStrMeasure14(data.getStrMeasure14());
        cocktail.setStrMeasure15(data.getStrMeasure15());

        cocktail.setStrTags(data.getStrTags());
        cocktail.setStrVideo(data.getStrVideo());

        cocktail.setStrInstructions(data.getStrInstructions());
        cocktail.setStrInstructionsDE(data.getStrInstructionsDE());
        cocktail.setStrInstructionsES(data.getStrInstructionsES());
        cocktail.setStrInstructionsFR(data.getStrInstructionsFR());
        cocktail.setStrInstructionsIT(data.getStrInstructionsIT());
        cocktail.setStrInstructionsZH_HANS(data.getStrInstructionsZH_HANS());
        cocktail.setStrInstructionsZH_HANT(data.getStrInstructionsZH_HANT());

        cocktail.setDateModified(data.getDateModified());
        return cocktail;
    }

    public static List<Cocktail> convertCocktails(List<CocktailModel> list) {
        List<Cocktail> l = new ArrayList<>();
        for (CocktailModel cocktailModel : list) {
            l.add(convertCocktail(cocktailModel));
        }
        return l;
    }
    public static <T> String getTextProperty(T prop) {
        return prop != null ? prop.toString() : "Không xác định";
    }

    public static List<FormulaCocktail> getFormulaList(Cocktail cocktail) {
        List<FormulaCocktail> list = new ArrayList<>();
        if (cocktail.getStrIngredient1() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient1(),
                    getTextProperty(cocktail.getStrMeasure1())
            ));
        }
        if (cocktail.getStrIngredient2() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient2(),
                    getTextProperty(cocktail.getStrMeasure2())
            ));
        }
        if (cocktail.getStrIngredient3() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient3(),
                    getTextProperty(cocktail.getStrMeasure3())
            ));
        }
        if (cocktail.getStrIngredient4() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient4(),
                    getTextProperty(cocktail.getStrMeasure4())
            ));
        }
        if (cocktail.getStrIngredient14() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient14(),
                    getTextProperty(cocktail.getStrMeasure14())
            ));
        }
        if (cocktail.getStrIngredient5() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient5(),
                    getTextProperty(cocktail.getStrMeasure5())
            ));
        }
        if (cocktail.getStrIngredient6() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient6(),
                    getTextProperty(cocktail.getStrMeasure6())
            ));
        }
        if (cocktail.getStrIngredient7() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient7(),
                    getTextProperty(cocktail.getStrMeasure7())
            ));
        }
        if (cocktail.getStrIngredient8() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient8(),
                    getTextProperty(cocktail.getStrMeasure8())
            ));
        }
        if (cocktail.getStrIngredient9() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient9(),
                    getTextProperty(cocktail.getStrMeasure9())
            ));
        }
        if (cocktail.getStrIngredient10() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient10(),
                    getTextProperty(cocktail.getStrMeasure10())
            ));
        }
        if (cocktail.getStrIngredient11() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient11(),
                    getTextProperty(cocktail.getStrMeasure11())
            ));
        }
        if (cocktail.getStrIngredient12() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient12(),
                    getTextProperty(cocktail.getStrMeasure12())
            ));
        }
        if (cocktail.getStrIngredient13() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient13(),
                    getTextProperty(cocktail.getStrMeasure13())
            ));
        }
        if (cocktail.getStrIngredient15() != null) {
            list.add(new FormulaCocktail(
                    cocktail.getStrIngredient15(),
                    getTextProperty(cocktail.getStrMeasure15())
            ));
        }
        return list;
    }

}
