class Branch {

    private String addressInstruction;
    private String addressTarget;
    private int taken;

    Branch() {

    }

    Branch(String addressInstruction, String addressTarget, taken) {
        self.addressInstruction = addressInstruction;
        self.addressTarget = addressTarget;
        self.taken = taken;
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
