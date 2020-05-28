public interface Model {
    /** Notifies all View objects registered to the model when the model is updated.
     *
     */
    public void notifyAllViews();

    /** Registers a View object so that it is notified whenever the model is updated.
     *
     * @param view = the view that wants to be updated about changes to the model
     */
    public void registerView(View view);

    /** Removes a view from being notified whenever the model is updated.
     *
     * @param view = the view that no longer wants to be updated about changes to the model
     */
    public void removeView(View view);

}
