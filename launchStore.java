
    void launchRateAppActivity()
    {
        String google = "market://details?id=";
        String amazon = "amzn://apps/android?p=";
        String base = google;

        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;

        if ((manufacturer != null) && manufacturer.contains("Amazon"))
        {
            base = amazon;
        }

        Uri uri = Uri.parse(base + getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try
        {
            startActivity(goToMarket);
        }
        catch (ActivityNotFoundException e)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

