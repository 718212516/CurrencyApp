package com.mperez15.currencyapp.helpers;

import com.mperez15.currencyapp.Constants;
import com.mperez15.currencyapp.value_objects.Currency;

import org.json.JSONObject;

/**
 * Created by dev on 17/12/2015.
 */
public class CurrencyParserHelper {

    public static Currency parseCurrency(JSONObject obj, String currencyName) {
        Currency currency = new Currency();
        currency.setBase(obj.optString(Constants.BASE));
        currency.setDate(obj.optString(Constants.DATE));
        JSONObject rateObject = obj.optJSONObject(Constants.RATES);
        if(rateObject != null) {
            currency.setRate(rateObject.optDouble(currencyName));
        }
        currency.setName(currencyName);
        return currency;
    }
}