/*
 * Copyright (C) 2018 Confidential Technologies GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cotech.sweetspot;


import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;


public class ShowNfcSweetspotActivity extends Activity {
    private View sweetspotIndicator;
    private View sweetspotIcon;
    private View sweetspotCircle1;
    private View sweetspotCircle2;
    private View sweetspotCircle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        overridePendingTransition(R.anim.fade_in_quick, R.anim.fade_out_quick);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nfc_sweetspot);
        sweetspotIndicator = findViewById(R.id.indicator_nfc_sweetspot);

        Pair<Double, Double> nfcPosition = NfcSweetspotData.getSweetspotForBuildModel();
        if (nfcPosition == null) {
            throw new IllegalArgumentException("No data available for this model. This activity should not be called!");
        }
        DisplayMetrics displayDimensions = getDisplaySize();

        final float translationX = (float) (displayDimensions.widthPixels * nfcPosition.first);
        final float translationY = (float) (displayDimensions.heightPixels * nfcPosition.second);

        sweetspotIndicator.post(new Runnable() {
            @Override
            public void run() {
                sweetspotIndicator.setTranslationX(translationX - sweetspotIndicator.getWidth() / 2);
                sweetspotIndicator.setTranslationY(translationY - sweetspotIndicator.getHeight() / 2);
            }
        });

        sweetspotIcon = findViewById(R.id.icon_nfc_sweetspot);
        sweetspotCircle1 = findViewById(R.id.circle_nfc_sweetspot_1);
        sweetspotCircle2 = findViewById(R.id.circle_nfc_sweetspot_2);
        sweetspotCircle3 = findViewById(R.id.circle_nfc_sweetspot_3);

        sweetspotIcon.setAlpha(0.0f);
        sweetspotCircle1.setAlpha(0.0f);
        sweetspotCircle2.setAlpha(0.0f);
        sweetspotCircle3.setAlpha(0.0f);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();

        DecelerateInterpolator interpolator = new DecelerateInterpolator();
        sweetspotIcon.animate().alpha(1.0f).setInterpolator(interpolator).setDuration(300).start();
        sweetspotCircle1.animate().alpha(1.0f).setInterpolator(interpolator).setDuration(500).setStartDelay(100).start();
        sweetspotCircle2.animate().alpha(1.0f).setInterpolator(interpolator).setDuration(700).setStartDelay(200).start();
        sweetspotCircle3.animate().alpha(1.0f).setInterpolator(interpolator).setDuration(1000).setStartDelay(300).start();
    }

    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(R.anim.fade_in_quick, R.anim.fade_out_quick);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            setResult(Activity.RESULT_CANCELED);
            finish();
            return true;
        }

        return super.onTouchEvent(event);
    }

    private DisplayMetrics getDisplaySize() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        return metrics;
    }
}
