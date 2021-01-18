package uwu.owler;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType;
import mindustry.game.EventType.*;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.net.Administration.*;
import mindustry.world.blocks.storage.*;

public class OwlerTD extends Plugin{
    int timer=0;
    public static Rules attack = new Rules();
    public static Rules defence = new Rules();
    public static boolean gameover =true;
    public static int gameoverTimer=0;
    @Override
    public void init(){
        attack.bannedBlocks.add(Blocks.duo);
        attack.bannedBlocks.add(Blocks.meltdown);
        attack.bannedBlocks.add(Blocks.scatter);
        attack.bannedBlocks.add(Blocks.scorch);
        attack.bannedBlocks.add(Blocks.hail);
        attack.bannedBlocks.add(Blocks.wave);
        attack.bannedBlocks.add(Blocks.lancer);
        attack.bannedBlocks.add(Blocks.arc);
        attack.bannedBlocks.add(Blocks.parallax);
        attack.bannedBlocks.add(Blocks.swarmer);
        attack.bannedBlocks.add(Blocks.salvo);
        attack.bannedBlocks.add(Blocks.segment);
        attack.bannedBlocks.add(Blocks.tsunami);
        attack.bannedBlocks.add(Blocks.fuse);
        attack.bannedBlocks.add(Blocks.ripple);
        attack.bannedBlocks.add(Blocks.cyclone);
        attack.bannedBlocks.add(Blocks.foreshadow);
        attack.bannedBlocks.add(Blocks.spectre);

        attack.bannedBlocks.add(Blocks.mender);
        attack.bannedBlocks.add(Blocks.mendProjector);
        attack.bannedBlocks.add(Blocks.forceProjector);
        attack.bannedBlocks.add(Blocks.shockMine);
        attack.bannedBlocks.add(Blocks.shockMine);

        attack.bannedBlocks.add(Blocks.copperWall);
        attack.bannedBlocks.add(Blocks.copperWallLarge);
        attack.bannedBlocks.add(Blocks.titaniumWall);
        attack.bannedBlocks.add(Blocks.titaniumWallLarge);
        attack.bannedBlocks.add(Blocks.plastaniumWall);
        attack.bannedBlocks.add(Blocks.plastaniumWallLarge);
        attack.bannedBlocks.add(Blocks.thoriumWall);
        attack.bannedBlocks.add(Blocks.thoriumWallLarge);
        attack.bannedBlocks.add(Blocks.phaseWall);
        attack.bannedBlocks.add(Blocks.phaseWallLarge);
        attack.bannedBlocks.add(Blocks.surgeWall);
        attack.bannedBlocks.add(Blocks.surgeWallLarge);

        defence.bannedBlocks.add(Blocks.commandCenter);
        defence.bannedBlocks.add(Blocks.groundFactory);
        defence.bannedBlocks.add(Blocks.airFactory);
        defence.bannedBlocks.add(Blocks.navalFactory);
        System.out.println("nope");
        Events.on(EventType.PlayerConnect.class,e->{
            e.player.team(Team.derelict);
        });
        Events.on(EventType.GameOverEvent.class,e->{
            gameover=true;
        });
        Events.on(WorldLoadEvent.class,e->{
            for(Player p:Groups.player){
                p.team(Team.derelict);
            }
            gameover=false;
        });
        Events.on(Trigger.update.getClass(),e->{
            if(gameover){return;}
            timer++;
            if(timer>100){
                gameoverTimer++;
                if(gameoverTimer>10000){
                    Events.fire(GameOverEvent.class,Team.green);gameover=true;gameoverTimer=0;return;
                }
                if(Vars.state.teams.cores(Team.green).first()!=null){
                Vars.state.teams.cores(Team.green).first().items.add(Items.copper, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.lead, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.graphite, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.silicon, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.metaglass, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.titanium, 1);Vars.state.teams.cores(Team.green).first().items.add(Items.copper, 150);
                Vars.state.teams.cores(Team.green).first().items.add(Items.thorium, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.plastanium, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.phaseFabric, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.surgeAlloy, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.sand, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.pyratite, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.blastCompound, 1);
                Vars.state.teams.cores(Team.green).first().items.add(Items.coal, 1);
                }
                if(Vars.state.teams.cores(Team.blue).first()!=null){
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.copper, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.lead, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.graphite, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.silicon, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.metaglass, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.titanium, 1);Vars.state.teams.cores(Team.blue).first().items.add(Items.copper, 150);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.thorium, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.plastanium, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.phaseFabric, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.surgeAlloy, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.sand, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.pyratite, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.blastCompound, 1);
                    Vars.state.teams.cores(Team.blue).first().items.add(Items.coal, 1);
                }
                timer=0;
            }
        });
    }

    @Override
    public void registerServerCommands(CommandHandler handler){

    }

    @Override
    public void registerClientCommands(CommandHandler handler){
        handler.<Player>register("def","nope",(args,player)->{
            player.unit().kill();
            player.team(Team.green);
            Call.setRules(player.con, defence);
        });
        handler.<Player>register("atk","nope",(args,player)->{
            player.unit().kill();
            player.team(Team.blue);
            Call.setRules(player.con, attack);
        });
    }
}
