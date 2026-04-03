package gs.mclo.forge.client;

public class CheatModule {
    private final String name;
    private final String description;
    private boolean enabled;

    public CheatModule(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void toggle() {
        enabled = !enabled;
    }
}
