package gs.mclo.forge.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;

import java.util.List;

public class ClickGuiScreen extends Screen {
    private static final int PANEL_X = 20;
    private static final int PANEL_Y = 20;
    private static final int PANEL_WIDTH = 240;
    private static final int PANEL_HEADER_HEIGHT = 26;
    private static final int BUTTON_HEIGHT = 20;

    private final List<CheatModule> modules;

    public ClickGuiScreen(List<CheatModule> modules) {
        super(new StringTextComponent("ClickGUI"));
        this.modules = modules;
    }

    @Override
    protected void init() {
        int y = PANEL_Y + PANEL_HEADER_HEIGHT + 10;

        for (CheatModule module : modules) {
            int currentY = y;
            addButton(new Button(PANEL_X + 10, currentY, PANEL_WIDTH - 20, BUTTON_HEIGHT, getButtonLabel(module), button -> {
                module.toggle();
                button.setMessage(getButtonLabel(module));
            }));
            y += BUTTON_HEIGHT + 6;
        }
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        renderBackground(matrixStack);

        fillGradient(matrixStack, PANEL_X, PANEL_Y, PANEL_X + PANEL_WIDTH, PANEL_Y + PANEL_HEADER_HEIGHT, 0xFF6C2CF5, 0xFFB84DFF);
        fillGradient(matrixStack, PANEL_X, PANEL_Y + PANEL_HEADER_HEIGHT, PANEL_X + PANEL_WIDTH, PANEL_Y + 190, 0xCC161A29, 0xCC0E111E);

        drawCenteredString(matrixStack, font, title, PANEL_X + PANEL_WIDTH / 2, PANEL_Y + 9, 0xFFFFFFFF);
        drawString(matrixStack, font, "Right Shift = Toggle GUI", PANEL_X + 10, PANEL_Y + 175, 0xFF8CA3D9);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private StringTextComponent getButtonLabel(CheatModule module) {
        String status = module.isEnabled() ? "§aON" : "§cOFF";
        return new StringTextComponent(module.getName() + "  [" + status + "§r]");
    }
}
