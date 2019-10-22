package entity;

public class TenantAnnouncement extends Announcement {
    private Filters fil;

    public TenantAnnouncement(String ownernick, String creationDate, Filters fil) {
        super(ownernick, creationDate);
        this.fil = fil;
    }

    @Override
    public String myType() {
        return "tenant";
    }

    public Filters getFilters() {
        return this.fil;
    }
}
