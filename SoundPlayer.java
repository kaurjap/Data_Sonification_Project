// SoundPlayer.java

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;


public class SoundPlayer {
    
    protected int pitch; // represents the notenumber for MIDI to be played
    protected int volume;
    protected int instrument;
    protected int duration; // in milliseconds
    protected int channel;
    
    public SoundPlayer() {
        this.pitch = 0;
        this.volume = 100;
        this.instrument = XYLOPHONE;
        this.duration = 250; // in milliseconds
        this.channel = 0;
    } // end constructor
    
    
    public SoundPlayer(int noteNum, int volume, int instr, int time, int channel) {
        this.pitch = noteNum;
        this.volume = volume;
        this.instrument = instr;
        this.duration = time;
        this.channel = channel;
    } // end parameterized constructor

    // constants representing different midi instruments
    public static int
        PIANO = 0,
        XYLOPHONE = 13,
        HARMONICA = 22,
        GUITAR = 24,
        VIOLIN = 40,
        TRUMPET = 56,
        FLUTE = 73,
        STEEL_DRUMS = 114;
        
    
    // method that plays the sound based on the set attributes of the class
    public void playSound() {
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            Instrument[] instruments = synth.getDefaultSoundbank().getInstruments();
            MidiChannel[] channels = synth.getChannels();
            synth.loadInstrument(instruments[this.instrument]);
            channels[this.channel].programChange(this.instrument); // this actually changes the instrument
            channels[this.channel].noteOn(this.pitch, this.volume);
            try { 
                Thread.sleep(this.duration); // wait time in milliseconds to control duration
            } catch( InterruptedException e ) { 
                System.out.println(e.getMessage());
            } // end try-catch
            channels[this.channel].noteOff(this.pitch); //turn of the note
            // System.out.println("ran till line 32 - noteOff method");
        } catch (MidiUnavailableException e) {
            System.out.println("inside catch of SoundPlayer....");
            System.out.println(e.getMessage());
        } // end try-catch
    } // end constructor
    
    
    // access methods
    public int getPitch() {
        return pitch;
    } // end getPitch

    public int getVolume() {
        return volume;
    } // end getVolume

    public int getInstrument() {
        return instrument;
    } // end getInstrument

    public int getDuration() {
        return duration;
    } // end getDuration

    public void setPitch(int pitch) {
        this.pitch = pitch;
    } // end setPitch

    public void setVolume(int volume) {
        this.volume = volume;
    } // end setVolume

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    } // end setInstrument

    public void setDuration(int duration) {
        this.duration = duration;
    } // end setDuration
    
} // end class def
