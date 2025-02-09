package no.hvl.data102.filmarkiv.impl;

public class LinearNode<T> {

    public T data; // Dataen lagret i noden
    public LinearNode<T> neste; // Referanse til neste node i listen

    public LinearNode() {
        this.data = null;
        this.neste = null;
    }


    public LinearNode(T data) {
        this.data = data;
        this.neste = null;
    }


}