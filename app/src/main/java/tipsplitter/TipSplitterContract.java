package tipsplitter;

import android.content.ContentValues;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

import java.util.Date;

/**
 * @author Martin Kocour
 *         created on 13.4.17
 */
public class TipSplitterContract {
    public static final String PROVIDER_URI = "content://com.kocopepo.tipsplitter.provider";

    public static class PaymentInfo {
        public static final String TABLE_NAME = "payment_info";
        public static final String URI = PROVIDER_URI + "/" + TABLE_NAME;

        public static final String COL_ID = BaseColumns._ID;
        public static final String COL_AMOUNT = "amount";
        public static final String COL_TIP = "tip";
        public static final String COL_SPENDING = "spending";
        public static final String COL_EMPLOYEE_ID = "employee_id";
        public static final String COL_EMPLOYEE_NAME = "employee_name";

        @NonNull
        public static final String COL_DELETED = "deleted";
        public static final String COL_CREATED = "created";
        public static final String COL_UPDATED = "updated";

        public static ContentValues createDefault(boolean inserted) {
            ContentValues values = new ContentValues();
            Date now = new Date();
            if (inserted) {
                values.put(COL_CREATED, now.getTime());
            }
            values.put(COL_DELETED, false);
            values.put(COL_UPDATED, now.getTime());
            return values;
        }
    }
}
