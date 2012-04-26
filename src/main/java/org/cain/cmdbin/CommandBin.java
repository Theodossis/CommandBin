package org.cain.cmdbin;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.cain.cmdbin.commands.AcceptCommand;
import org.cain.cmdbin.commands.AddXpCommand;
import org.cain.cmdbin.commands.AfkCommand;
import org.cain.cmdbin.commands.AskCommand;
import org.cain.cmdbin.commands.BackCommand;
import org.cain.cmdbin.commands.BlindCommand;
import org.cain.cmdbin.commands.BlockCommand;
import org.cain.cmdbin.commands.BoldCommand;
import org.cain.cmdbin.commands.BoltCommand;
import org.cain.cmdbin.commands.BroadcastCommand;
import org.cain.cmdbin.commands.ChunkCommand;
import org.cain.cmdbin.commands.ClearCommand;
import org.cain.cmdbin.commands.CommandBinCommand;
import org.cain.cmdbin.commands.CreateWorldCommand;
import org.cain.cmdbin.commands.CreativeCommand;
import org.cain.cmdbin.commands.DenyCommand;
import org.cain.cmdbin.commands.DisableHardcoreCommand;
import org.cain.cmdbin.commands.DrunkCommand;
import org.cain.cmdbin.commands.EnableHardcoreCommand;
import org.cain.cmdbin.commands.ExplodeCommand;
import org.cain.cmdbin.commands.ExplosionBowCommand;
import org.cain.cmdbin.commands.FakeopCommand;
import org.cain.cmdbin.commands.FeedCommand;
import org.cain.cmdbin.commands.FreezeCommand;
import org.cain.cmdbin.commands.FsayCommand;
import org.cain.cmdbin.commands.GetXpCommand;
import org.cain.cmdbin.commands.GmCommand;
import org.cain.cmdbin.commands.GmoCommand;
import org.cain.cmdbin.commands.GodCommand;
import org.cain.cmdbin.commands.GrowtreeCommand;
import org.cain.cmdbin.commands.HandicapCommand;
import org.cain.cmdbin.commands.HealCommand;
import org.cain.cmdbin.commands.HoleCommand;
import org.cain.cmdbin.commands.HomeCommand;
import org.cain.cmdbin.commands.IPCommand;
import org.cain.cmdbin.commands.IsvanishedCommand;
import org.cain.cmdbin.commands.ItalicCommand;
import org.cain.cmdbin.commands.ItemCommand;
import org.cain.cmdbin.commands.JoinCommand;
import org.cain.cmdbin.commands.KillCommand;
import org.cain.cmdbin.commands.KillallCommand;
import org.cain.cmdbin.commands.LeaveCommand;
import org.cain.cmdbin.commands.LockCommand;
import org.cain.cmdbin.commands.MhomeCommand;
import org.cain.cmdbin.commands.MsethomeCommand;
import org.cain.cmdbin.commands.MsgCommand;
import org.cain.cmdbin.commands.MuteCommand;
import org.cain.cmdbin.commands.NickCommand;
import org.cain.cmdbin.commands.PotionCommand;
import org.cain.cmdbin.commands.PutCommand;
import org.cain.cmdbin.commands.RamCommand;
import org.cain.cmdbin.commands.RealnameCommand;
import org.cain.cmdbin.commands.SetHomeCommand;
import org.cain.cmdbin.commands.SetXpCommand;
import org.cain.cmdbin.commands.SetlevelCommand;
import org.cain.cmdbin.commands.SetspawnCommand;
import org.cain.cmdbin.commands.SetwarpCommand;
import org.cain.cmdbin.commands.ShootCommand;
import org.cain.cmdbin.commands.SkyCommand;
import org.cain.cmdbin.commands.SlapCommand;
import org.cain.cmdbin.commands.SpawnCommand;
import org.cain.cmdbin.commands.SpawnerCommand;
import org.cain.cmdbin.commands.SpawnmobCommand;
import org.cain.cmdbin.commands.StrikeCommand;
import org.cain.cmdbin.commands.StrikethroughCommand;
import org.cain.cmdbin.commands.SudoCommand;
import org.cain.cmdbin.commands.SurvivalCommand;
import org.cain.cmdbin.commands.TPcCommand;
import org.cain.cmdbin.commands.TentCommand;
import org.cain.cmdbin.commands.ThorCommand;
import org.cain.cmdbin.commands.TimeCommand;
import org.cain.cmdbin.commands.Tp2pCommand;
import org.cain.cmdbin.commands.TpCommand;
import org.cain.cmdbin.commands.TpWorldCommand;
import org.cain.cmdbin.commands.TpallCommand;
import org.cain.cmdbin.commands.TphereCommand;
import org.cain.cmdbin.commands.TphomeCommand;
import org.cain.cmdbin.commands.TrollCommand;
import org.cain.cmdbin.commands.UnHandicapCommand;
import org.cain.cmdbin.commands.UnMuteCommand;
import org.cain.cmdbin.commands.UnblockCommand;
import org.cain.cmdbin.commands.UnderlineCommand;
import org.cain.cmdbin.commands.UnfreezeCommand;
import org.cain.cmdbin.commands.UnloadWorldCommand;
import org.cain.cmdbin.commands.UnlockCommand;
import org.cain.cmdbin.commands.VanishCommand;
import org.cain.cmdbin.commands.VoidCommand;
import org.cain.cmdbin.commands.WarpCommand;
import org.cain.cmdbin.commands.WeatherCommand;
import org.cain.cmdbin.listeners.blockListener;
import org.cain.cmdbin.listeners.playerListener;

public class CommandBin extends JavaPlugin
{
  Logger log = Logger.getLogger("Minecraft");
  public static CommandBin plugin;
  public static boolean updateAvailable;
  public static String updateVersion;
  

  public void onEnable()
  {
    plugin = this;
    getConfig();
    addConfigurationDefaults();
    printURLMessage();
    registerEvents();
    if (!getDescription().getCommands().toString().toLowerCase().contains("commandbin")) {
      System.out.println("[CommandBin] Detected that you have removed /commandbin from plugin.yml");
      System.out.println("[CommandBin] CommandBin does not allow this. Have a bit of pride!");
      System.out.println("[CommandBin] Disabling CommandBin due to this..");
      Bukkit.getServer().getPluginManager().disablePlugin(this);
    } else {
      registerCommands(); // ...
    }
  }

  public void onDisable() {
  }

  public void addConfigurationDefaults() {
    getConfig().addDefault("enable-auto-updater", true);
    getConfig().addDefault("enable-in-game-autoupdate", true);
    getConfig().addDefault("download-update", true);
    getConfig().addDefault("enable-debug-mode", false);
    getConfig().options().copyDefaults(true);
    saveConfig();
  }

  public void printURLMessage() {
    try {
      URL url = new URL("http://dl.dropbox.com/u/7186172/CommandBin/message.txt");
      BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
      String str;
      while ((str = in.readLine()) != null)
      {
        if (!str.equalsIgnoreCase(getDescription().getVersion())) {
          if (getConfig().getBoolean("enable-auto-updater")) {
            System.out.println("========================================");
            System.out.println("+ [CommandBin] A new update is available (" + str + ").");
            System.out.println("+ [CommandBin] Download it at http://dev.bukkit.org/server-mods/CommandBin");
            System.out.println("========================================");
          }
          updateAvailable = true;
          updateVersion = str;

          if (getConfig().getBoolean("download-update")) {
            downloadCommandBin();
          }
        }
      }
      in.close(); } catch (MalformedURLException localMalformedURLException) {
    } catch (IOException e) {
      System.out.println("[CommandBin] There was a problem reading from the online file.");
    }
  }

  public static void downloadCommandBin() {
    try {
      URL url = new URL("http://dl.dropbox.com/u/7186172/CommandBin/download.txt");
      BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
      String str;
      while ((str = in.readLine()) != null)
      {
        System.out.println("========================================");
        System.out.println("+ [CommandBin] Detected in Configuration to download latest version of CommandBin..");
        System.out.println("+ [CommandBin] Downloading ..");
        saveUrl("plugins/CommandBin.jar", str);
        System.out.println("+ [CommandBin] CommandBin has been downloaded. Please reload.");
        System.out.println("========================================");
        updateAvailable = false;
      }
      in.close(); } catch (MalformedURLException localMalformedURLException) {
    } catch (IOException e) {
      System.out.println("[CommandBin] There was a problem reading from the online file.");
    }
  }

  public static void saveUrl(String filename, String urlString) throws MalformedURLException, IOException {
    BufferedInputStream in = null;
    FileOutputStream fout = null;
    try
    {
      in = new BufferedInputStream(new URL(urlString).openStream());
      fout = new FileOutputStream(filename);

      byte[] data = new byte[1024];
      int count;
      while ((count = in.read(data, 0, 1024)) != -1)
      {
        fout.write(data, 0, count);
      }
    }
    finally
    {
      if (in != null)
        in.close();
      if (fout != null)
        fout.close();
    }
  }

  public void registerEvents() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new blockListener(), this);
    pm.registerEvents(new playerListener(), this);
  }

  public void registerCommands() {
    rc("accept", new AcceptCommand());
    rc("addxp", new AddXpCommand());
    rc("ask", new AskCommand());
    rc("back", new BackCommand());
    rc("blind", new BlindCommand());
    rc("block", new BlockCommand());
    rc("bolt", new BoltCommand());
    rc("broadcast", new BroadcastCommand());
    rc("chunk", new ChunkCommand());
    rc("clear", new ClearCommand());
    rc("createworld", new CreateWorldCommand());
    rc("creative", new CreativeCommand());
    rc("deny", new DenyCommand());
    rc("disablehardcore", new DisableHardcoreCommand());
    rc("drunk", new DrunkCommand());
    rc("enablehardcore", new EnableHardcoreCommand());
    rc("explode", new ExplodeCommand());
    rc("explosionbow", new ExplosionBowCommand());
    rc("fakeop", new FakeopCommand());
    rc("feed", new FeedCommand());
    rc("freeze", new FreezeCommand());
    rc("fsay", new FsayCommand());
    rc("getxp", new GetXpCommand());
    rc("gm", new GmCommand());
    rc("gmo", new GmoCommand());
    rc("god", new GodCommand());
    rc("growtree", new GrowtreeCommand());
    rc("handicap", new HandicapCommand());
    rc("heal", new HealCommand());
    rc("home", new HomeCommand());
    rc("ip", new IPCommand());
    rc("isvanished", new IsvanishedCommand());
    rc("join", new JoinCommand());
    rc("kill", new KillCommand());
    rc("leave", new LeaveCommand());
    rc("lock", new LockCommand());
    rc("mhome", new MhomeCommand());
    rc("msethome", new MsethomeCommand());
    rc("msg", new MsgCommand());
    rc("mute", new MuteCommand());
    rc("nick", new NickCommand());
    rc("potion", new PotionCommand());
    rc("put", new PutCommand());
    rc("ram", new RamCommand());
    rc("realname", new RealnameCommand());
    rc("sethome", new SetHomeCommand());
    rc("setlevel", new SetlevelCommand());
    rc("setspawn", new SetspawnCommand());
    rc("setwarp", new SetwarpCommand());
    rc("setxp", new SetXpCommand());
    rc("shoot", new ShootCommand());
    rc("slap", new SlapCommand());
    rc("spawn", new SpawnCommand());
    rc("strike", new StrikeCommand());
    rc("sudo", new SudoCommand());
    rc("survival", new SurvivalCommand());
    rc("tent", new TentCommand());
    rc("thor", new ThorCommand());
    rc("time", new TimeCommand());
    rc("tp2p", new Tp2pCommand());
    rc("tpall", new TpallCommand());
    rc("tp", new TpCommand());
    rc("tphere", new TphereCommand());
    rc("tphome", new TphomeCommand());
    rc("tpworld", new TpWorldCommand());
    rc("unblock", new UnblockCommand());
    rc("unfreeze", new UnfreezeCommand());
    rc("unhandicap", new UnHandicapCommand());
    rc("unloadworld", new UnloadWorldCommand());
    rc("unlock", new UnlockCommand());
    rc("unmute", new UnMuteCommand());
    rc("vanish", new VanishCommand());
    rc("warp", new WarpCommand());
    rc("weather", new WeatherCommand());
    rc("spawner", new SpawnerCommand());
    rc("bold", new BoldCommand());
    rc("strikethrough", new StrikethroughCommand());
    rc("italic", new ItalicCommand());
    rc("underline", new UnderlineCommand());
    rc("afk", new AfkCommand());
    rc("commandbin", new CommandBinCommand());
    rc("killall", new KillallCommand());
    rc("tpc", new TPcCommand());
    rc("sky", new SkyCommand());
    rc("void", new VoidCommand());
    rc("troll", new TrollCommand());
    rc("spawnmob", new SpawnmobCommand());
    rc("item", new ItemCommand());
    rc("hole", new HoleCommand());
  }

  public void rc(String command, CommandExecutor ce) {
    if (getDescription().getCommands().toString().toLowerCase().contains(command))
      Bukkit.getServer().getPluginCommand(command).setExecutor(ce);
  }

  public static boolean permissionCheck(Player p, String node)
  {
    return p.hasPermission(node);
  }
}