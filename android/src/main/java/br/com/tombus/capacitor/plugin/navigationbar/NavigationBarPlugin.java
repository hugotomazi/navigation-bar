package br.com.tombus.capacitor.plugin.navigationbar;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CapacitorPlugin(name = "NavigationBar")
public class NavigationBarPlugin extends Plugin {

    private NavigationBar implementation = new NavigationBar();

    @PluginMethod
    public void hide(PluginCall call) {
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                    Window window = getActivity().getWindow();
                    View view = window.getDecorView();
                    int options = view.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

                    view.setSystemUiVisibility(options);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

                    notifyListeners("onHide", new JSObject());
                    call.resolve();
                } else {
                    call.unavailable("Not available on Android API 14 or earlier.");
                }
            }
        });
    }

    @PluginMethod
    public void show(PluginCall call) {
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                    Window window = getActivity().getWindow();
                    View view = window.getDecorView();
                    int options = view.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_HIDE_NAVIGATION & ~View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

                    view.setSystemUiVisibility(options);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

                    notifyListeners("onShow", new JSObject());
                    call.resolve();
                } else {
                    call.unavailable("Not available on Android API 14 or earlier.");
                }
            }
        });
    }

    @PluginMethod
    public void setColor(PluginCall call) {
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String color = call.getString("color");
                    Boolean darkButtons = call.getBoolean("darkButtons");

                    if(color == null || color.isEmpty()) {
                        color = "#FFFFFF";
                    }

                    if(!this.validateHexColor(color)) {
                        call.reject("Invalid Hexadecimal color");
                        return;
                    }

                    if(darkButtons == null) {
                        darkButtons = false;
                    }

                    Window window = getActivity().getWindow();
                    int options = window.getDecorView().getSystemUiVisibility() | WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && darkButtons) {
                        options |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
                    } else {
                        options &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
                    }

                    window.getDecorView().setSystemUiVisibility(options);
                    window.setNavigationBarColor(Color.parseColor(color));
                    String newColor = String.format("#%06X", (0xFFFFFF & window.getNavigationBarColor()));

                    JSObject ret = new JSObject();
                    ret.put("color", newColor);
                    notifyListeners("onColorChange", ret);

                    call.resolve();
                } else {
                    call.unavailable("Not available on Android API 21 or earlier.");
                }
            }

            private boolean validateHexColor(String color) {
                if (color == null || color.isEmpty()) {
                    return false;
                }

                Pattern pattern = Pattern.compile("^#([A-Fa-f0-9]{6})$");
                return pattern.matcher(color).matches();
            }
        });
    }

    @PluginMethod
    public void getColor(PluginCall call) {
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getActivity().getWindow();
                    String color = String.format("#%06X", (0xFFFFFF & window.getNavigationBarColor()));

                    JSObject colorObject = new JSObject();
                    colorObject.put("color", color);
                    call.resolve(colorObject);
                } else {
                    call.unavailable("Not available on Android API 21 or earlier.");
                }
            }
        });
    }
}
