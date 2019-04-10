package com.patient.harman.patientinfo.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by arupanig on 4/10/2019.
 */

public class Utils {
    private Utils() {

    }

    /*
    * Will create a JsonObject to return it.
    *
    * @return JsonObject.
    * */
    public static JsonObject getReservationListBody() {
        final JsonObject jsonBody = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("HandoverNotes");
        try {

            jsonBody.addProperty("ItemsPerPage", 50);
            jsonBody.add("Include", jsonArray);
            jsonBody.addProperty("Page", 0);
        } catch (Exception e) {

        }
        return jsonBody;
    }
}
