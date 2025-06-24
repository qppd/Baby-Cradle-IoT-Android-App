package com.qppd.babycradle;
import android.os.Bundle;
import android.content.Intent;
import com.daimajia.androidanimations.library.Techniques;
import com.qppd.babycradle.Libs.IntentManager.IntentManagerClass;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;
import java.util.Objects;

public class MainActivity extends AwesomeSplash {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splashscreen);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    @Override
    public void initSplash(ConfigSplash configSplash) {
        configSplash.setBackgroundColor(R.color.white);
        configSplash.setAnimCircularRevealDuration(250);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);
        configSplash.setTitleSplash("Baby Cradle");
        configSplash.setTitleTextColor(R.color.black);
        configSplash.setLogoSplash(R.drawable.applogo); //or any other drawable
        configSplash.setAnimLogoSplashDuration(3000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.BounceInUp);
    }

    @Override
    public void animationsFinished() {
        IntentManagerClass.intentsify(MainActivity.this, DashboardActivity.class,
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.finish();
    }
}