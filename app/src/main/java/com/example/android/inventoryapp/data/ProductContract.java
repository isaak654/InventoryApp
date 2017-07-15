package com.example.android.inventoryapp.data;


import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class ProductContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ProductContract() {
    }

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.inventoryapp";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.inventoryapp/products/ is a valid path for
     * looking at product data. content://com.example.android.inventoryapp/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_PRODUCTS = "products";

    /**
     * Inner class that defines constant values for the products database table.
     * Each entry in the table represents a single product.
     */
    public static class ProductEntry implements BaseColumns {

        // The content URI to access the products data in the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PRODUCTS);

        // The MIME type of the {@link #CONTENT_URI} for a list of products.
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        // The MIME type of the {@link #CONTENT_URI} for a single product.
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        // Name of database table for products
        public static final String TABLE_NAME = "products";

        //Unique ID number for the product - Type: INTEGER
        public static final String _ID = BaseColumns._ID;

        // Name of the product - Type: TEXT
        public static final String COLUMN_PRODUCT_NAME = "name";

        // Quantity of the product - Type: INTEGER
        public static final String COLUMN_PRODUCT_QUANTITY = "quantity";

        // Price of the product - Type: INTEGER
        public static final String COLUMN_PRODUCT_PRICE = "price";

        // Image of the product - Type: TEXT
        public static final String COLUMN_PRODUCT_IMAGE = "image";

        // Supplier of the product - Type: TEXT
        public static final String COLUMN_SUPPLIER_NAME = "supplier";

        // Supplier email - Type: TEXT
        public static final String COLUMN_SUPPLIER_EMAIL = "supplierEmail";
    }
}