package hi.practice.menu;

public class Menu {

    private Long id;
    private String name;
    private EventMenu eventMenu;

    public Menu(Long id, String name, EventMenu eventMenu) {
        this.id = id;
        this.name = name;
        this.eventMenu = eventMenu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventMenu getEventMenu() {
        return eventMenu;
    }

    public void setEventMenu(EventMenu eventMenu) {
        this.eventMenu = eventMenu;
    }
}
