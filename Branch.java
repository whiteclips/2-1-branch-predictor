class Branch {

    private String addressInstruction;
    private String addressTarget;
    private int taken;

    Branch(String addressInstruction, String addressTarget, int taken) {
        this.addressInstruction = addressInstruction;
        this.addressTarget = addressTarget;
        this.taken = taken;
    }

    public String getAddressInstruction() {
        return addressInstruction;
    }

    public String getAddressTarget() {
        return addressTarget;
    }

    public int isTaken() {
        return taken;
    }

}
