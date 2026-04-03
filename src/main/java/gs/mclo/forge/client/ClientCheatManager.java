package gs.mclo.forge.client;

import com.mojang.blaze3d.platform.InputMappings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

import java.util.Arrays;
import java.util.List;

public class ClientCheatManager {
    private static final String KEY_CATEGORY = "key.categories.mclogs";
    private static final String OPEN_GUI_KEY = "key.mclogs.open_clickgui";

    private static final List<CheatModule> MODULES = Arrays.asList(
            new CheatModule("Speed", "Move faster than normal"),
            new CheatModule("Fly", "Allows free flight"),
            new CheatModule("ESP", "Highlights entities through walls"),
            new CheatModule("AutoTotem", "Keeps totem in offhand automatically")
    );

    private static final KeyBinding OPEN_GUI = new KeyBinding(
            OPEN_GUI_KEY,
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            KEY_CATEGORY
    );

    public static void register() {
        ClientRegistry.registerKeyBinding(OPEN_GUI);
    }

    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (!OPEN_GUI.isDown()) {
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.screen == null) {
            minecraft.setScreen(new ClickGuiScreen(MODULES));
        }
    }
}
